package com.mymarket.mvp.accounts;

import org.springframework.stereotype.Component;

@Component
public class AccountResponseMapper {

    public AccountResponseDTO toDTO(Account account) {

        if (account == null) {
            return null;
        }

        return new AccountResponseDTO(account.getUsername(), account.getFirstName(), account.getLastName(), account.isEnabled());
    }

}