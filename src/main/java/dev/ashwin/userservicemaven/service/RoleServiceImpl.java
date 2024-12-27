package dev.ashwin.userservicemaven.service;

import dev.ashwin.userservicemaven.dto.RoleRequestDTO;
import dev.ashwin.userservicemaven.dto.RoleResponseDTO;
import dev.ashwin.userservicemaven.entity.Role;
import dev.ashwin.userservicemaven.repository.RoleRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRoleName(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getDescription());
        return RoleResponseDTO.from(roleRepository.save(role));
    }
}
