package com.neotrade.infrastructure.persistence.mapper;

import com.neotrade.domain.model.user.User;
import com.neotrade.infrastructure.persistence.entity.user.UserEntity;
import com.neotrade.infrastructure.persistence.entity.user.UserRole;
import com.neotrade.shared.enumeration.Role;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper extends BaseMapper<User, UserEntity> {

    @Override
    public User toDomain(UserEntity entity) {
        User domain = User.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .kycLevel(entity.getKycLevel())
                .roles(entity.getRoles().stream().map(UserRole::getRole).collect(Collectors.toSet()))
                .build();
        setupBaseFieldsOnDomain(entity, domain);
        return domain;
    }

    @Override
    public UserEntity toEntity(User domain) {
        UserEntity entity = UserEntity.builder()
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .email(domain.getEmail())
                .kycLevel(domain.getKycLevel())
                .build();
        setupBaseFieldsOnEntity(domain, entity);
        setupUserEntityRoles(entity, domain.getRoles());
        return entity;
    }

    private void setupUserEntityRoles(UserEntity entity, Set<Role> roles) {
        Set<UserRole> userRoles = roles.stream()
                .map(role -> new UserRole(entity, role))
                .collect(Collectors.toSet());
        entity.setRoles(userRoles);
    }
}
