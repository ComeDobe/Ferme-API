package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.config.JwtUtils;
import com.Dobe.Ferme.dto.Auth.AuthenticationRequest;
import com.Dobe.Ferme.dto.Auth.AuthenticationResponse;
import com.Dobe.Ferme.dto.UtilisateurDto;
import com.Dobe.Ferme.models.Role;
import com.Dobe.Ferme.models.Utilisateur;
import com.Dobe.Ferme.repositories.RoleRepository;
import com.Dobe.Ferme.repositories.UtilisateurRepository;
import com.Dobe.Ferme.services.UtilisateurService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private static final String ROLE_USER = "ROLE_USER";
    private final UtilisateurRepository utilisateurRepository;
    private final ObjectsValidator<UtilisateurDto> validator;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authManager;
    private final RoleRepository roleRepository;

    @Override
    public Integer save(UtilisateurDto dto) {
        validator.validate(dto);
        Utilisateur utilisateur = UtilisateurDto.toEntity(dto);
        return utilisateurRepository.save(utilisateur).getId();
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll()
                .stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur trouvé avec cet Id: " + id));
    }

    @Override
    public void delete(Integer id) {
    utilisateurRepository.deleteById(id);
    }

    @Override
    public Integer validateAccount(Integer id) {
        Utilisateur utilisateur=utilisateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur avec ce cmopte"));
        utilisateur.setActive(true);
        utilisateurRepository.save(utilisateur);
        return utilisateur.getId();
    }

    @Override
    public Integer invalidateAccount(Integer id) {
        Utilisateur utilisateur=utilisateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur avec ce cmopte"));
        utilisateur.setActive(false);
        utilisateurRepository.save(utilisateur);
        return utilisateur.getId();
    }

    @Override
    public Integer registerUtilisateur(Integer id) {
        return null;
    }

    @Override
    public Integer updateUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur=UtilisateurDto.toEntity(utilisateurDto);
        return utilisateurRepository.save(utilisateur).getId();
    }

    @Override
    @Transactional
    public AuthenticationResponse register(UtilisateurDto utilisateurDto) {
        validator.validate(utilisateurDto);
        Utilisateur utilisateur = UtilisateurDto.toEntity(utilisateurDto);
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
//        utilisateur.addRole(findOrCreateRole(ROLE_USER)); // Utilisez addRole ici
        var savedUser = utilisateurRepository.save(utilisateur);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", savedUser.getId());
        claims.put("fullName", savedUser.getFirstName() + " " + savedUser.getLastName());
        String token = jwtUtils.generateToken(savedUser, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }


    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final Utilisateur utilisateur = utilisateurRepository.findByEmail(request.getEmail()).get();
        Map<String, Object> claims = new HashMap<>();
        claims.put("utilisateurId", utilisateur.getId());
        claims.put("fullName", utilisateur.getFirstName() + " " + utilisateur.getLastName());
        final String token = jwtUtils.generateToken(utilisateur, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
    private Role findOrCreateRole(String roleName) {
        Role role = roleRepository.findByRoleName(roleName)
                .orElse(null);
        if (role == null) {
            return roleRepository.save(
                    Role.builder()
                            .roleName(roleName)
                            .build()
            );
        }
        return role;
    }


}
