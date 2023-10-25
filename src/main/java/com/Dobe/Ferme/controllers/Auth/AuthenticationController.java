package com.Dobe.Ferme.controllers.Auth;

import com.Dobe.Ferme.dto.Auth.AuthenticationRequest;
import com.Dobe.Ferme.dto.Auth.AuthenticationResponse;
import com.Dobe.Ferme.dto.UtilisateurDto;
import com.Dobe.Ferme.repositories.UtilisateurRepository;
import com.Dobe.Ferme.services.UtilisateurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthenticationController {

    private final UtilisateurService utilisateurService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UtilisateurDto utilisateurDto) {

        return ResponseEntity.ok(utilisateurService.register(utilisateurDto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(utilisateurService.authenticate(request));
    }

}
