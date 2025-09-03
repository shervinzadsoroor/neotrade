package com.neotrade.application.port.in.user;

public record RegisterUserCommand(String email, String password, String firstName, String lastName) {
}
