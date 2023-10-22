package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.PlanteDto;
import com.Dobe.Ferme.dto.ProductionDto;
import com.Dobe.Ferme.models.Plante;
import com.Dobe.Ferme.models.Production;
import com.Dobe.Ferme.repositories.PlanteRepository;
import com.Dobe.Ferme.repositories.ProductionRepository;
import com.Dobe.Ferme.services.PlanteService;
import com.Dobe.Ferme.services.ProductionService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {
    private  final ProductionRepository productionRepository;
    private final ObjectsValidator<ProductionDto> validator;
    @Override
    public Integer save(ProductionDto dto) {
        validator.validate(dto);
        Production  production = ProductionDto.toEntity(dto);
        return productionRepository.save(production).getId();
    }

    @Override
    public List<ProductionDto> findAll() {
        return productionRepository.findAll()
                .stream()
                .map(ProductionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProductionDto findById(Integer id) {
        return productionRepository.findById(id)
                .map(ProductionDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" l'id de la production non trouvée"));
    }

    @Override
    public void delete(Integer id) {
        productionRepository.deleteById(id);
    }
}
