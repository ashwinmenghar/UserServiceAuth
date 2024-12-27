package dev.ashwin.userservicemaven.dto;

import dev.ashwin.userservicemaven.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponseDTO {
    private String role;
    private String desc;
    private UUID id;

    public static RoleResponseDTO from(Role role) {
        RoleResponseDTO dto = new RoleResponseDTO();
        dto.role = role.getRoleName();
        dto.desc = role.getDescription();
        return dto;
    }
}
