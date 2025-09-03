package com.neotrade.infrastructure.persistence.mapper;

import com.neotrade.domain.model.user.User;
import com.neotrade.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper<User, UserEntity> {

    @Override
    public User toDomain(UserEntity entity) {
        User domain = User.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .kycLevel(entity.getKycLevel())
                .roles(entity.getRoles())
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
                .roles(domain.getRoles())
                .build();
        setupBaseFieldsOnEntity(domain, entity);
        return entity;
    }
}
