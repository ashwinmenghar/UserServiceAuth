package dev.ashwin.userservicemaven.service;

import dev.ashwin.userservicemaven.dto.*;

import javax.management.relation.RoleNotFoundException;

public interface UserService {
    UserResponseDTO signup(SignupRequestDTO signupRequestDTO) throws RoleNotFoundException;
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    boolean validateToken(String token);
    boolean logout(String token);
}
