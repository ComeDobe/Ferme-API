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
    @GetMapping("/{mteriel-id}")
    public ResponseEntity<MaterielDto> findById(@PathVariable ("materiel-id") Integer materielId){
        return ResponseEntity.ok(materielService.findById(materielId));
    }
    @DeleteMapping("/{mteriel-id}")
    public ResponseEntity<Void> delete(@PathVariable ("materiel-id") Integer materielId ) {
        materielService.delete(materielId);
        return ResponseEntity.accepted().build();
    }

}