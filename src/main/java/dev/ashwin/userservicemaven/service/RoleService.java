package dev.ashwin.userservicemaven.service;

import dev.ashwin.userservicemaven.dto.RoleRequestDTO;
import dev.ashwin.userservicemaven.dto.RoleResponseDTO;

public interface RoleService {
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
}
