package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.ParcelleDto;
import com.Dobe.Ferme.models.Parcelle;
import com.Dobe.Ferme.repositories.ParcelleRepository;
import com.Dobe.Ferme.services.ParcelleService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParcelleServiceImpl implements ParcelleService {

    private final ParcelleRepository parcelleRepository;
    private final ObjectsValidator<ParcelleDto> validator;

    @Override
    public Integer save(ParcelleDto dto) {
        validator.validate(dto);
        Parcelle parcelle = ParcelleDto.toEntity(dto);
        return parcelleRepository.save(parcelle).getId();
    }

    @Override
    public List<ParcelleDto> findAll() {
        return parcelleRepository.findAll()
                .stream()
                .map(ParcelleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ParcelleDto findById(Integer id) {
        return parcelleRepository.findById(id)
                .map(ParcelleDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("parcel non trouvée par on id " + id));
    }

    @Override
    public void delete(Integer id) {

        parcelleRepository.deleteById(id);
    }
}
