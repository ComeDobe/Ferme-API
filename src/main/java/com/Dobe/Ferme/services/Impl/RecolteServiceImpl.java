package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.PlanteDto;
import com.Dobe.Ferme.dto.RecolteDto;
import com.Dobe.Ferme.models.Plante;
import com.Dobe.Ferme.models.Recolte;
import com.Dobe.Ferme.repositories.PlanteRepository;
import com.Dobe.Ferme.repositories.RecolteRepository;
import com.Dobe.Ferme.services.PlanteService;
import com.Dobe.Ferme.services.RecolteService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecolteServiceImpl implements RecolteService {
    private  final RecolteRepository recolteRepository;
    private final ObjectsValidator<RecolteDto> validator;
    @Override
    public Integer save(RecolteDto dto) {
        validator.validate(dto);
        Recolte recolte = RecolteDto.toEntity(dto);
        return recolteRepository.save(recolte).getId();
    }

    @Override
    public List<RecolteDto> findAll() {
        return recolteRepository.findAll()
                .stream()
                .map(RecolteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RecolteDto findById(Integer id) {
        return recolteRepository.findById(id)
                .map(RecolteDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" l'id de la recolte non trouvée"));
    }

    @Override
    public void delete(Integer id) {
        recolteRepository.deleteById(id);
    }
}
