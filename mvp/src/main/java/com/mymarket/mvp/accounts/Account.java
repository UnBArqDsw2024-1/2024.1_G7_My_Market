package com.mymarket.mvp.accounts;

import java.io.Serial;
import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Account entity represents user account in the application.
 *
 * @author Pedro Lucas
 * @since 1.0
 */
@Entity
@Table(name = "accounts", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "firstName"})
public final class Account implements Serializable {

    /**
     * The serialVersionUID.
     */
    @Serial
    private static final long serialVersionUID = 221625420706334299L;

    /**
     * The unique identifier for the account.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username for authentication. Must contain only letters and numbers.
     */
    @Column(length = 23, nullable = false, unique = true)
    @Length(min = 6, max = 23)
    @NotBlank(message = "The username cannot be blank")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$", message = "The username must contain only letters (at least one letter) and numbers (at least one number)")
    private String username;

    /**
     * The password for authentication. Must contain at least one letter and one
     * number.
     */
    @Column(name = "password", nullable = false)
    @JsonIgnore
    @NotBlank(message = "The password cannot be blank")
    private String password;

    /**
     * The first name of the account holder.
     */
    @Column(length = 30, nullable = false)
    @Length(min = 1, max = 30)
    @NotBlank(message = "The name cannot be blank")
    private String firstName;

    /**
     * (Optional) The last name or surname of the account holder.
     */
    @Column(length = 30)
    @Length(max = 30)
    private String lastName;

    /**
     * Indicates whether it is account non expired. False by default.
     */
    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isAccountNonExpired;

    /**
     * Indicates whether it is account non-locked. False by default.
     */
    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isAccountNonLocked;

    /**
     * Indicates whether it is account with credentials non expired. False by
     * default.
     */
    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isCredentialsNonExpired;

    /**
     * Indicates whether it is enabled. False by default.
     */
    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isEnabled;

    /**
     * The role of the account in the system.
     */
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

}