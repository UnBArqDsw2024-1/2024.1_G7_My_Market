package com.mymarket.mvp.accounts;

import com.mymarket.mvp.auth.AuthService;
import com.mymarket.mvp.shared.exception.ElementAlreadyPresentException;
import com.mymarket.mvp.shared.exception.RecordNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.Optional;

@Validated
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountRequestMapper accountCreateRequestMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    public AccountService(AccountRepository accountRepository, AccountRequestMapper accountCreateRequestMapper,
                          PasswordEncoder passwordEncoder, AuthService authService) {
        this.accountRepository = accountRepository;
        this.accountCreateRequestMapper = accountCreateRequestMapper;
        this.passwordEncoder = passwordEncoder;
        this.authService = authService;
    }

    public Optional<Account> findAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public Optional<Account> getAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetail) {
            return Optional.of(((UserDetail) authentication.getPrincipal()).getAccount());
        }
        return Optional.empty();
    }

    @Transactional
    public void create(AccountRequestDTO accountRequestDTO) {

        if (findAccountByUsername(accountRequestDTO.username()).isPresent()) {
            throw new ElementAlreadyPresentException(accountRequestDTO.username());
        }

        Account account = accountCreateRequestMapper.toAccount(accountRequestDTO, passwordEncoder);
        accountRepository.save(account);
    }

    @Transactional
    public void updateUsername(HttpServletRequest request, HttpServletResponse response, Authentication authentication,
                               UsernameRequestDTO usernameRequestDTO) {

        Account account = getAccount().orElseThrow(() -> new RecordNotFoundException("User"));

        if (findAccountByUsername(usernameRequestDTO.username()).isPresent()) {
            throw new ElementAlreadyPresentException(usernameRequestDTO.username());
        }

        account.setUsername(usernameRequestDTO.username());

        accountRepository.save(account);
        authService.logoutSessions(request, response, authentication);
    }

    @Transactional
    public void updatePassword(HttpServletRequest request, HttpServletResponse response, Authentication authentication,
                               String password) {

        Account account = getAccount().orElseThrow(() -> new RecordNotFoundException("User"));

        account.setPassword(passwordEncoder.encode(password));
        accountRepository.save(account);
        authService.logoutSessions(request, response, authentication);
    }

    @Transactional
    public void delete(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Account account = getAccount().orElseThrow(() -> new RecordNotFoundException("User"));
        accountRepository.delete(account);
    }
}