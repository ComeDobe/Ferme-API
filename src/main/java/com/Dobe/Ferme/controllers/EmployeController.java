package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.EmployeDto;
import com.Dobe.Ferme.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employes")
public class EmployeController {

    private final EmployeService employeService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody EmployeDto employeDto){
        return ResponseEntity.ok(employeService.save(employeDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeDto>> findAll() {
        return ResponseEntity.ok(employeService.findAll());
    }

    @GetMapping("/{employeId}")
    public ResponseEntity<EmployeDto> findById(@PathVariable Integer employeId) {
        return ResponseEntity.ok(employeService.findById(employeId));
    }

    @DeleteMapping("/{employeId}")
    public ResponseEntity<Void> delete(@PathVariable Integer employeId) {
        employeService.delete(employeId);
        return ResponseEntity.accepted().build();
    }
}
