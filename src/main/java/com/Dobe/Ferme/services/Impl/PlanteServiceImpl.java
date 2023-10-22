package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.PlantationDto;
import com.Dobe.Ferme.dto.PlanteDto;
import com.Dobe.Ferme.models.Plantation;
import com.Dobe.Ferme.models.Plante;
import com.Dobe.Ferme.repositories.PlantationRepository;
import com.Dobe.Ferme.repositories.PlanteRepository;
import com.Dobe.Ferme.services.PlantationService;
import com.Dobe.Ferme.services.PlanteService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanteServiceImpl implements PlanteService {
    private  final PlanteRepository planteRepository;
    private final ObjectsValidator<PlanteDto> validator;
    @Override
    public Integer save(PlanteDto dto) {
        validator.validate(dto);
        Plante plante = PlanteDto.toEntity(dto);
        return planteRepository.save(plante).getId();
    }

    @Override
    public List<PlanteDto> findAll() {
        return planteRepository.findAll()
                .stream()
                .map(PlanteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PlanteDto findById(Integer id) {
        return planteRepository.findById(id)
                .map(PlanteDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" l'id de la plante non trouvée"));
    }

    @Override
    public void delete(Integer id) {
    planteRepository.deleteById(id);
    }
}
