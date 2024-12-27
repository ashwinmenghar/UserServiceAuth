package dev.ashwin.userservicemaven.controller;

import dev.ashwin.userservicemaven.dto.LoginRequestDTO;
import dev.ashwin.userservicemaven.dto.SignupRequestDTO;
import dev.ashwin.userservicemaven.dto.UserResponseDTO;
import dev.ashwin.userservicemaven.service.RoleService;
import dev.ashwin.userservicemaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(userService.login(loginRequestDTO));
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorisation") String token) {
        return ResponseEntity.ok(userService.logout(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody SignupRequestDTO signupRequestDTO) throws RoleNotFoundException {
        return ResponseEntity.ok(userService.signup(signupRequestDTO));
    }

    @GetMapping("/validate")
    public ResponseEntity validate(@RequestHeader("Authorisation") String token) {
        return ResponseEntity.ok(userService.validateToken(token));
    }
}
