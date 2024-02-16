package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.UtilisateurDto;
import com.Dobe.Ferme.repositories.UtilisateurRepository;
import com.Dobe.Ferme.services.UtilisateurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/utilisateurs")
@Tag(name = "utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final UtilisateurRepository utilisateurRepository;

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Integer> save(@RequestBody UtilisateurDto utilisateurDto){
        return ResponseEntity.ok(utilisateurService.update(utilisateurDto));
    }


    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UtilisateurDto>> findAll() {
        return ResponseEntity.ok(utilisateurService.findAll());
    }

    @GetMapping("/{utilisateurId}")
    public ResponseEntity<UtilisateurDto> findById(@PathVariable  Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.findById(utilisateurId));
    }
    @DeleteMapping("/{utilisateurId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable  Integer utilisateurId ) {
        utilisateurService.delete(utilisateurId);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/validate/{utilisateurId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Integer> validateAccount(@PathVariable  Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.validateAccount(utilisateurId));
    }

    @PatchMapping("/invalidate/{utilisateurId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Integer> invalidateAccount(@PathVariable  Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.invalidateAccount(utilisateurId));
    }
}
