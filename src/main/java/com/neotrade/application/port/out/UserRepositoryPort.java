package com.neotrade.application.port.out;

import com.neotrade.domain.model.user.User;

import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> finaByEmail(String email);

    boolean existsByEmail(String email);
}
