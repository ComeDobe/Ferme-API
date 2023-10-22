package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.RegimeDto;
import com.Dobe.Ferme.dto.TacheDto;
import com.Dobe.Ferme.models.Regime;
import com.Dobe.Ferme.models.Tache;
import com.Dobe.Ferme.repositories.RegimeRepository;
import com.Dobe.Ferme.repositories.TacheRepository;
import com.Dobe.Ferme.services.RegimeService;
import com.Dobe.Ferme.services.TacheService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TacheServiceImpl implements TacheService {
    private  final TacheRepository tacheRepository;
    private final ObjectsValidator<TacheDto> validator;
    @Override
    public Integer save(TacheDto dto) {
        validator.validate(dto);
        Tache tache = TacheDto.toEntity(dto);
        return tacheRepository.save(tache).getId();
    }

    @Override
    public List<TacheDto> findAll() {
        return tacheRepository.findAll()
                .stream()
                .map(TacheDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TacheDto findById(Integer id) {
        return tacheRepository.findById(id)
                .map(TacheDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" l'id de la tache non trouvée"));
    }

    @Override
    public void delete(Integer id) {
        tacheRepository.deleteById(id);
    }
}
