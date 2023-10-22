package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.EspeceDto;
import com.Dobe.Ferme.models.Espece;
import com.Dobe.Ferme.repositories.EspeceRepository;
import com.Dobe.Ferme.services.EspeceService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EspeceServiceImpl implements EspeceService {
    private  final EspeceRepository especeRepository;
    private ObjectsValidator<EspeceDto> validator;
    @Override
    public Integer save(EspeceDto dto) {
        validator.validate(dto);
        Espece espece=EspeceDto.toEntity(dto);
        return especeRepository.save(espece).getId();
    }

    @Override
    public List<EspeceDto> findAll() {
        return especeRepository.findAll()
                .stream()
                .map(EspeceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EspeceDto findById(Integer id) {
        return especeRepository.findById(id)
                .map(EspeceDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("l'espece n'a pas été trouvé par son id : " + id));
    }

    @Override
    public void delete(Integer id) {
    especeRepository.deleteById(id);
    }
}
