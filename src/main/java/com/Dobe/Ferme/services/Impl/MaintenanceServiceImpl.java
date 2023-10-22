package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.MaintenanceDto;
import com.Dobe.Ferme.models.Maintenance;
import com.Dobe.Ferme.repositories.MaintenanceRepository;
import com.Dobe.Ferme.services.MaintenanceService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final ObjectsValidator<MaintenanceDto> validator;
    @Override
    public Integer save(MaintenanceDto dto) {
        validator.validate(dto);
        Maintenance maintenance=MaintenanceDto.toEntity(dto);
        return maintenanceRepository.save(maintenance).getId();
    }

    @Override
    public List<MaintenanceDto> findAll() {
        return maintenanceRepository.findAll()
                .stream()
                .map(MaintenanceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MaintenanceDto findById(Integer id) {
        return maintenanceRepository.findById(id)
                .map(MaintenanceDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" l'objet n'a pas été trouvé par son id : " + id));
    }
    @Override
    public void delete(Integer id) {
        maintenanceRepository.deleteById(id);

    }
}
