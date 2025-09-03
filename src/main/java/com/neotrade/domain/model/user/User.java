package com.neotrade.domain.model.user;

import com.neotrade.domain.model.BaseDomain;
import com.neotrade.shared.enumeration.KYCLevel;
import com.neotrade.shared.enumeration.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter
@Builder
public class User extends BaseDomain {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private KYCLevel kycLevel;
    private Set<Role> roles;
}
