package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.AnimalDto;
import com.Dobe.Ferme.models.Animal;
import com.Dobe.Ferme.repositories.AnimalRepository;
import com.Dobe.Ferme.services.AnimalService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final ObjectsValidator<AnimalDto> validator;

    @Override
    public Integer save(AnimalDto dto) {
        validator.validate(dto);
        Animal animal =AnimalDto.toEntity(dto);
        return animalRepository.save(animal).getId();
    }

    @Override
    public List<AnimalDto> findAll() {
        return animalRepository.findAll()
                .stream()
                .map(AnimalDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AnimalDto findById(Integer id) {
        return animalRepository.findById(id)
                .map(AnimalDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(" cet utilisateur n'a pas été trouvé par son id: " + id));
    }

    @Override
    public void delete(Integer id) {
        animalRepository.deleteById(id);

    }
}
