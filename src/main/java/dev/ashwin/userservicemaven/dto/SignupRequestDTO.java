package dev.ashwin.userservicemaven.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SignupRequestDTO {
    private String name;
    private String email;
    private String password;
    private UUID roleId;
}
