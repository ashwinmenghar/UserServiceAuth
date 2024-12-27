package dev.ashwin.userservicemaven.service;

import dev.ashwin.userservicemaven.dto.LoginRequestDTO;
import dev.ashwin.userservicemaven.dto.SignupRequestDTO;
import dev.ashwin.userservicemaven.dto.UserResponseDTO;
import dev.ashwin.userservicemaven.entity.Role;
import dev.ashwin.userservicemaven.entity.User;
import dev.ashwin.userservicemaven.exception.InvalidCredentialException;
import dev.ashwin.userservicemaven.exception.RoleNotFoundException;
import dev.ashwin.userservicemaven.exception.UserNotFoundException;
import dev.ashwin.userservicemaven.repository.RoleRepository;
import dev.ashwin.userservicemaven.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponseDTO signup(SignupRequestDTO signupRequestDTO) throws RoleNotFoundException {
        Role role = roleRepository.findById(signupRequestDTO.getRoleId()).orElseThrow(
                () -> new RoleNotFoundException("Role not found")
        );

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(signupRequestDTO.getName());
        user.setPassword(signupRequestDTO.getPassword());
        user.setEmailId(signupRequestDTO.getEmail());
        user.setRoles(List.of(role));

        return UserResponseDTO.from(userRepository.save(user));
    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        User savedUser = userRepository.findByEmailId(loginRequestDTO.getEmail()).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!loginRequestDTO.getPassword().equals(savedUser.getPassword())) {
            throw new InvalidCredentialException();
        }

        String userData = savedUser.getEmailId() + savedUser.getPassword() + LocalDateTime.now();
        String token = userData;
        savedUser.setToken(token);

        savedUser = userRepository.save(savedUser);
        return UserResponseDTO.from(savedUser);
    }


    @Override
    public boolean validateToken(String token) {
        userRepository.findByToken(token).orElseThrow(
                () -> new UserNotFoundException("Token is not valid")
        );
        return true;
    }

    @Override
    public boolean logout(String token) {
        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new UserNotFoundException("Token is not valid")
        );
        savedUser.setToken(null);
        userRepository.save(savedUser);
        return true;
    }
}
