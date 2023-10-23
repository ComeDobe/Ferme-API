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

    @GetMapping("/{utilisateur-id}")
    public ResponseEntity<UtilisateurDto> findById(@PathVariable ("utilisateur-id") Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.findById(utilisateurId));
    }
    @DeleteMapping("/{utilisateur-id}")
    public ResponseEntity<Void> delete(@PathVariable ("utilisateur-id") Integer utilisateurId ) {
        utilisateurService.delete(utilisateurId);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/validate/{utilisateur-id}")
    public ResponseEntity<Integer> validateAccount(@PathVariable ("utilisateur-id") Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.validateAccount(utilisateurId));
    }

    @PatchMapping("/invalidate/{utilisateur-id}")
    public ResponseEntity<Integer> invalidateAccount(@PathVariable ("utilisateur-id") Integer utilisateurId){
        return ResponseEntity.ok(utilisateurService.invalidateAccount(utilisateurId));
    }
}
