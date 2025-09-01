package com.neotrade.domain.model.user;

import com.neotrade.domain.model.BaseEntity;
import com.neotrade.shared.enumeration.KYCLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER", schema = "NEOTRADE")
public class User extends BaseEntity {

    private static final String TABLE_NAME = "USER";

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "KYC_LEVEL", nullable = false)
    @Enumerated(EnumType.STRING)
    private KYCLevel kycLevel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> roles;
}
