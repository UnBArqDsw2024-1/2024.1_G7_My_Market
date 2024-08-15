package com.mymarket.mvp.accounts;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

/**
 * UserDetail implements the UserDetails interface for Spring Security
 * integration.
 * 
 * @since 1.0
 * @author Pedro Lucas
 */
public class UserDetail implements UserDetails {

	/** The serial version UID. */
	@Serial
	private static final long serialVersionUID = -6676620567638122748L;

	private final Account account;

	public UserDetail(Account account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.account.getRole() == Role.ROLE_ADMIN) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		} else {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}

	@Override
	public String getPassword() {
		return this.account.getPassword();
	}

	@Override
	public String getUsername() {
		return this.account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.account.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.account.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.account.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return this.account.isEnabled();
	}

}