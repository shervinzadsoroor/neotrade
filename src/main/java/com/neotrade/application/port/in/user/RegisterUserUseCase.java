package com.neotrade.application.port.in.user;

import com.neotrade.domain.model.user.User;

public interface RegisterUserUseCase {

    User registerUser(RegisterUserCommand command);
}
