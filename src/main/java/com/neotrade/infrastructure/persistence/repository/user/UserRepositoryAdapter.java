package com.neotrade.infrastructure.persistence.repository.user;

import com.neotrade.application.port.out.UserRepositoryPort;
import com.neotrade.domain.model.user.User;
import com.neotrade.infrastructure.persistence.entity.UserEntity;
import com.neotrade.infrastructure.persistence.mapper.UserMapper;
import com.neotrade.infrastructure.persistence.repository.PersistenceContextProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter extends PersistenceContextProvider implements UserRepositoryPort {

    private final JpaUserRepository jpaRepository;
    private final UserMapper mapper;

    @Override
    public User save(User user) {
        UserEntity entity = jpaRepository.save(mapper.toEntity(user));
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<User> finaByEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}
