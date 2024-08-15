package com.mymarket.mvp.accounts;

import com.mymarket.mvp.shared.exception.ElementAlreadyPresentException;
import com.mymarket.mvp.shared.exception.RecordNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;
    private final AccountResponseMapper accountResponseMapper;

    public AccountController(AccountService accountService, AccountResponseMapper accountResponseMapper) {
        this.accountService = accountService;
        this.accountResponseMapper = accountResponseMapper;
    }

    @GetMapping("/auth/accounts/current")
    public AccountResponseDTO getAccount() {
        return accountService.getAccount().map(accountResponseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException("User"));
    }

    @PostMapping("/public/accounts")
    public ResponseEntity<Void> create(@RequestBody AccountRequestDTO accountCreateRequestDTO) {
        try {
            accountService.create(accountCreateRequestDTO);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/auth/accounts/current/patch-username")
    public ResponseEntity<Void> patchUsername(HttpServletRequest request, HttpServletResponse response,
                                              Authentication authentication, @RequestBody @Valid UsernameRequestDTO usernameRequestDTO) {
        try {
            accountService.updateUsername(request, response, authentication, usernameRequestDTO);
            return ResponseEntity.ok().build();
        } catch (RecordNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ElementAlreadyPresentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PatchMapping("/auth/accounts/current/patch-password")
    public ResponseEntity<Void> patchPassword(HttpServletRequest request, HttpServletResponse response,
                                              Authentication authentication, @RequestBody PasswordRequestDTO passwordRequestDTO) {
        try {
            accountService.updatePassword(request, response, authentication, passwordRequestDTO.password());
            return ResponseEntity.ok().build();
        } catch (RecordNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/auth/accounts/current")
    public ResponseEntity<Void> delete(HttpServletRequest request, HttpServletResponse response,
                                       Authentication authentication) {
        accountService.delete(request, response, authentication);
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader("Location", "/api/auth/accounts/logout");
        return ResponseEntity.noContent().build();
    }

}