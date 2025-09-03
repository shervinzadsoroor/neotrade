package com.neotrade.application.service.user;

import com.neotrade.application.port.in.user.RegisterUserCommand;
import com.neotrade.application.port.in.user.RegisterUserUseCase;
import com.neotrade.application.port.out.UserRepositoryPort;
import com.neotrade.domain.model.user.User;
import com.neotrade.shared.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User registerUser(RegisterUserCommand command) {
        if (userRepository.existsByEmail(command.email())) {
            throw new UserAlreadyExistsException(command.email());
        }
        String encoded = passwordEncoder.encode(command.password());
        User user = User.builder()
                .email(command.email())
                .password(encoded)
                .firstName(command.firstName())
                .lastName(command.lastName())
                .build();
        return userRepository.save(user);
    }
}
