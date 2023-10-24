package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.MaintenanceDto;
import com.Dobe.Ferme.dto.MaterielDto;
import com.Dobe.Ferme.services.MaintenanceService;
import com.Dobe.Ferme.services.MaterielService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/materiels")
public class MaterielController {

    private final MaterielService materielService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody MaterielDto materielDto){
        return ResponseEntity.ok(materielService.save(materielDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<MaterielDto>> findAll(){
        return ResponseEntity.ok(materielService.findAll());
    }
    @GetMapping("/{mterielId}")
    public ResponseEntity<MaterielDto> findById(@PathVariable Integer materielId){
        return ResponseEntity.ok(materielService.findById(materielId));
    }
    @DeleteMapping("/{mterielId}")
    public ResponseEntity<Void> delete(@PathVariable Integer materielId ) {
        materielService.delete(materielId);
        return ResponseEntity.accepted().build();
    }

}
