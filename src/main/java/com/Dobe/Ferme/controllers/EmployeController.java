package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.AnimalDto;
import com.Dobe.Ferme.dto.EmployeDto;
import com.Dobe.Ferme.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/emplyes")
public class EmployeController {

    private final EmployeService employeService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody EmployeDto employeDTo){
        return  ResponseEntity.ok(employeService.save(employeDTo));
    }
    @GetMapping("/")
    public ResponseEntity <List<EmployeDto>> findAll() {
        return ResponseEntity.ok(employeService.findAll());
    }
    @PatchMapping("/{employe-id }")
    public ResponseEntity<EmployeDto> findById (@PathVariable ("employe-id") Integer employeId) {
        return ResponseEntity.ok(employeService.findById(employeId));
    }
    @PatchMapping("/{employe-id }")
    public ResponseEntity <Void> delete (@PathVariable ("employe-id") Integer employeId){
        employeService.delete(employeId);
        return ResponseEntity.accepted().build();
    }
}
