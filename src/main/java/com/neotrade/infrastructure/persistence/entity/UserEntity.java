package com.neotrade.infrastructure.persistence.entity;

import com.neotrade.domain.model.user.UserRole;
import com.neotrade.shared.enumeration.KYCLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER", schema = "NEOTRADE")
public class UserEntity extends BaseEntity {

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
