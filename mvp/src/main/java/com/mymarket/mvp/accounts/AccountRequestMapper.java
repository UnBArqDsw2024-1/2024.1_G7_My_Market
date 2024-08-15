package com.mymarket.mvp.accounts;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public final class AccountRequestMapper {

    public AccountRequestDTO toDTO(Account account) {

        if (account == null) {
            return null;
        }

        return new AccountRequestDTO(account.getUsername(), account.getPassword(), account.getFirstName(),
                account.getLastName());
    }

    public Account toAccount(AccountRequestDTO accountRequestDTO, PasswordEncoder passwordEncoder) {
        if (accountRequestDTO == null) {
            return null;
        }

        Account account = new Account();

        if (accountRequestDTO.username() != null) {
            account.setUsername(accountRequestDTO.username());
        }
        if (accountRequestDTO.password() != null) {
            account.setPassword(passwordEncoder.encode(accountRequestDTO.password()));
        }
        if (accountRequestDTO.firstName() != null) {
            account.setFirstName(accountRequestDTO.firstName());
        }
        if (accountRequestDTO.lastName() != null) {
            account.setLastName(accountRequestDTO.lastName());
        }
        account.setAccountNonExpired(true);
        account.setAccountNonLocked(true);
        account.setCredentialsNonExpired(true);
        account.setEnabled(true);
        account.setRole(Role.ROLE_USER);

        return account;
    }

}