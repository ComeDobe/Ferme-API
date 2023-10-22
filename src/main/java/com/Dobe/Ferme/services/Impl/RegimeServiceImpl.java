package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.RecolteDto;
import com.Dobe.Ferme.dto.RegimeDto;
import com.Dobe.Ferme.models.Recolte;
import com.Dobe.Ferme.models.Regime;
import com.Dobe.Ferme.repositories.RecolteRepository;
import com.Dobe.Ferme.repositories.RegimeRepository;
import com.Dobe.Ferme.services.RecolteService;
import com.Dobe.Ferme.services.RegimeService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegimeServiceImpl implements RegimeService {
    private  final RegimeRepository regimeRepository;
    private final ObjectsValidator<RegimeDto> validator;
    @Override
    public Integer save(RegimeDto dto) {
        validator.validate(dto);
        Regime regime = RegimeDto.toEntity(dto);
        return regimeRepository.save(regime).getId();
    }

    @Override
    public List<RegimeDto> findAll() {
        return regimeRepository.findAll()
                .stream()
                .map(RegimeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RegimeDto findById(Integer id) {
        return regimeRepository.findById(id)
                .map(RegimeDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" l'id du regime non trouvée"));
    }

    @Override
    public void delete(Integer id) {
        regimeRepository.deleteById(id);
    }
}
