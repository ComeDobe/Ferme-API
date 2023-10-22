package com.Dobe.Ferme.services.Impl;


import com.Dobe.Ferme.dto.EspeceDto;
import com.Dobe.Ferme.dto.FermeDto;
import com.Dobe.Ferme.models.Espece;
import com.Dobe.Ferme.models.Ferme;
import com.Dobe.Ferme.repositories.EspeceRepository;
import com.Dobe.Ferme.repositories.FermeRepository;
import com.Dobe.Ferme.services.EspeceService;
import com.Dobe.Ferme.services.FermeService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FermeServiceImpl implements FermeService {
    private  final FermeRepository fermeRepository;
    private ObjectsValidator<FermeDto> validator;
    @Override
    public Integer save(FermeDto dto) {
        validator.validate(dto);
        Ferme ferme=FermeDto.toEntity(dto);
        return fermeRepository.save(ferme).getId();
    }

    @Override
    public List<FermeDto> findAll() {
        return fermeRepository.findAll()
                .stream()
                .map(FermeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FermeDto findById(Integer id) {
        return fermeRepository.findById(id)
                .map(FermeDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("la ferme n'a pas été trouvée par son id : " + id));
    }

    @Override
    public void delete(Integer id) {
        fermeRepository.deleteById(id);
    }
}
