package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.UtilisateurDto;
import com.Dobe.Ferme.repositories.UtilisateurRepository;
import com.Dobe.Ferme.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final UtilisateurRepository utilisateurRepository;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody UtilisateurDto utilisateurDto){
        return ResponseEntity.ok(utilisateurService.save(utilisateurDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UtilisateurDto>> findAll() {
        return ResponseEntity.ok(utilisateurService.findAll());
    }

    @GetMapping("/{utilisateurId}")
    public ResponseEntity<UtilisateurDto> findById(@PathVariable  Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.findById(utilisateurId));
    }
    @DeleteMapping("/{utilisateurId}")
    public ResponseEntity<Void> delete(@PathVariable  Integer utilisateurId ) {
        utilisateurService.delete(utilisateurId);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/validate/{utilisateurId}")
    public ResponseEntity<Integer> validateAccount(@PathVariable  Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.validateAccount(utilisateurId));
    }

    @PatchMapping("/invalidate/{utilisateurId}")
    public ResponseEntity<Integer> invalidateAccount(@PathVariable  Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.invalidateAccount(utilisateurId));
    }
}
