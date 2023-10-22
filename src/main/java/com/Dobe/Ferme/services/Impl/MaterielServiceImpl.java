package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.MaintenanceDto;
import com.Dobe.Ferme.dto.MaterielDto;
import com.Dobe.Ferme.models.Maintenance;
import com.Dobe.Ferme.models.Materiel;
import com.Dobe.Ferme.repositories.MaintenanceRepository;
import com.Dobe.Ferme.repositories.MaterielRepository;
import com.Dobe.Ferme.services.MaterielService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterielServiceImpl implements MaterielService {

    private final MaterielRepository materielRepository;
    private final ObjectsValidator<MaterielDto> validator;
    @Override
    public Integer save(MaterielDto dto) {
        validator.validate(dto);
        Materiel materiel= MaterielDto.toEntity(dto);
        return materielRepository.save(materiel).getId();
    }

    @Override
    public List<MaterielDto> findAll() {
        return materielRepository.findAll()
                .stream()
                .map(MaterielDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MaterielDto findById(Integer id) {
        return materielRepository.findById(id)
                .map(MaterielDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("le materiel est indisponible à cet id " + id));
    }

    @Override
    public void delete(Integer id) {
        materielRepository.deleteById(id);

    }
}
