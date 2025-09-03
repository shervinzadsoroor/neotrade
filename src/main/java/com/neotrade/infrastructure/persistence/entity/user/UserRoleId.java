package com.neotrade.infrastructure.persistence.entity.user;

import com.neotrade.shared.enumeration.Role;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserRoleId implements Serializable {

    private UserEntity user;
    private Role role;
}
