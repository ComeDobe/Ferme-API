package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.AlimentDto;
import com.Dobe.Ferme.models.Aliment;
import com.Dobe.Ferme.repositories.AlimentRepository;
import com.Dobe.Ferme.services.AlimentService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlimentServiceImpl implements AlimentService {
    private final AlimentRepository alimentRepository;
    private final ObjectsValidator<AlimentDto> validator;

    @Override
    public Integer save(AlimentDto dto) {
        validator.validate(dto);
        Aliment aliment = AlimentDto.toEntity(dto);
        return alimentRepository.save(aliment).getId();

    }

    @Override
    public List<AlimentDto> findAll() {
        return alimentRepository.findAll()
                .stream()
                .map(AlimentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AlimentDto findById(Integer id) {
        return alimentRepository.findById(id)
                .map(AlimentDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" Aucun utilisateur trouvé avec cet id " + id));
    }

    @Override
    public void delete(Integer id) {
        alimentRepository.deleteById(id);

    }
}
