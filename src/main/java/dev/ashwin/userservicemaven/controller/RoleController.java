package dev.ashwin.userservicemaven.controller;

import dev.ashwin.userservicemaven.dto.RoleRequestDTO;
import dev.ashwin.userservicemaven.dto.RoleResponseDTO;
import dev.ashwin.userservicemaven.entity.Role;
import dev.ashwin.userservicemaven.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        return ResponseEntity.ok(roleService.createRole(roleRequestDTO));
    }
}
