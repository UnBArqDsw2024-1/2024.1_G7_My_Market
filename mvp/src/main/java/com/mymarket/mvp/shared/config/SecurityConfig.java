package com.mymarket.mvp.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter.Directive;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import com.mymarket.mvp.accounts.UserDetailService;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig<S extends Session> {
	private final FindByIndexNameSessionRepository<S> sessionRepository;
	private final UserDetailService userDetailService;

	public SecurityConfig(FindByIndexNameSessionRepository<S> sessionRepository, UserDetailService userDetailService) {
		this.sessionRepository = sessionRepository;
		this.userDetailService = userDetailService;
	}

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		HeaderWriterLogoutHandler clearSiteData = new HeaderWriterLogoutHandler(
				new ClearSiteDataHeaderWriter(Directive.ALL));

		httpSecurity.cors(Customizer.withDefaults()).csrf(csrf -> csrf.
				ignoringRequestMatchers("/h2-console/**").disable())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/h2-console/**").permitAll()
						.requestMatchers("/api/public/**").permitAll()
						.requestMatchers("/api/auth/**").hasAnyRole("ADMIN", "USER")
						.requestMatchers("/api/private/**").hasRole("ADMIN")
						.anyRequest().authenticated())
				.userDetailsService(userDetailService)
				.sessionManagement(session -> session
						.sessionFixation().migrateSession()
						.invalidSessionUrl("/api/public/authentication/login?invalid")
						.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(2)
						.maxSessionsPreventsLogin(false).expiredUrl("/api/public/authentication/login?expired")
						.sessionRegistry(sessionRegistry()))
				.logout(logout -> logout
						.addLogoutHandler(clearSiteData)
						.deleteCookies("SESSION")
						.invalidateHttpSession(true)
						.logoutUrl("/api/auth/authentication/logout")
						.logoutSuccessUrl("/api/public/authentication/login?logout")
						.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
				.httpBasic(Customizer.withDefaults())
				.headers(httpSecurityHeadersConfigurer -> {
				    httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
				 });

		return httpSecurity.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("http://localhost:4200"));
		configuration.setAllowedMethods(
				Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD", "TRACE", "CONNECT"));
		configuration.setAllowedHeaders(List.of("Accept", "Cookie", "Set-Cookie", "Origin", "Content-Type", "Depth",
				"User-Agent", "If-Modified-Since", "Cache-Control", "Authorization", "X-Req", "X-File-Size",
				"X-Requested-With", "X-File-Name"));
		configuration.setExposedHeaders(List.of("Cookie", "Set-Cookie", "Authorization"));
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

    @Bean
    SpringSessionBackedSessionRegistry<S> sessionRegistry() {
		return new SpringSessionBackedSessionRegistry<>(this.sessionRepository);
	}

    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}