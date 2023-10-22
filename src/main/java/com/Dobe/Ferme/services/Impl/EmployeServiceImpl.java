package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.EmployeDto;
import com.Dobe.Ferme.models.Employe;
import com.Dobe.Ferme.repositories.EmployeRepository;
import com.Dobe.Ferme.services.EmployeService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;
    private final ObjectsValidator < EmployeDto> validator;
    @Override
    public Integer save(EmployeDto dto) {
        validator.validate(dto);
        Employe employe = EmployeDto.toEntity(dto);
        return employeRepository.save(employe).getId();
    }

    @Override
    public List<EmployeDto> findAll() {
        return employeRepository.findAll()
                .stream()
                .map(EmployeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeDto findById(Integer id) {
        return employeRepository.findById(id)
                .map(EmployeDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("utilisateur non trouvé par son id : " + id));
    }

    @Override
    public void delete(Integer id) {
    employeRepository.deleteById(id);
    }
}
