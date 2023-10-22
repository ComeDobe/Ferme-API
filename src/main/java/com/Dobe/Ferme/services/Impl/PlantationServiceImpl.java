package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.PlantationDto;
import com.Dobe.Ferme.models.Plantation;
import com.Dobe.Ferme.repositories.PlantationRepository;
import com.Dobe.Ferme.services.PlantationService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlantationServiceImpl implements PlantationService {
    private  final PlantationRepository plantationRepository;
    private final ObjectsValidator<PlantationDto> validator;
    @Override
    public Integer save(PlantationDto dto) {
        validator.validate(dto);
        Plantation plantation = PlantationDto.toEntity(dto);
        return plantationRepository.save(plantation).getId();
    }

    @Override
    public List<PlantationDto> findAll() {
        return plantationRepository.findAll()
                .stream()
                .map(PlantationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PlantationDto findById(Integer id) {
        return plantationRepository.findById(id)
                .map(PlantationDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" l'id de la plantation non trouvée"));
    }

    @Override
    public void delete(Integer id) {
    plantationRepository.deleteById(id);
    }
}
