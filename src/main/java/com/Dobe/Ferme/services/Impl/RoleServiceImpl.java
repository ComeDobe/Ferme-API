package com.Dobe.Ferme.services.Impl;

import com.Dobe.Ferme.dto.RoleDto;
import com.Dobe.Ferme.repositories.RoleRepository;
import com.Dobe.Ferme.services.RoleService;
import com.Dobe.Ferme.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository  roleRepository;
    private final ObjectsValidator<RoleDto> validator;
    @Override
    public Integer save(RoleDto dto) {
        return null;
    }

    @Override
    public List<RoleDto> findAll() {
        return null;
    }

    @Override
    public RoleDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
