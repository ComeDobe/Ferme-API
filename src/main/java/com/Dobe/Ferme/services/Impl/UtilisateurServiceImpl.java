package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.UtilisateurDto;
import com.Dobe.Ferme.models.Utilisateur;
import com.Dobe.Ferme.repositories.UtilisateurRepository;
import com.Dobe.Ferme.services.UtilisateurService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final ObjectsValidator<UtilisateurDto> validator;

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
}
