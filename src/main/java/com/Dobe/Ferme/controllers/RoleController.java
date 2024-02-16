package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.RoleDto;
import com.Dobe.Ferme.services.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
@Tag(name = "roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<List<RoleDto>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleDto> findById(@PathVariable Integer roleId) {
        return ResponseEntity.ok(roleService.findById(roleId));
    }
}
