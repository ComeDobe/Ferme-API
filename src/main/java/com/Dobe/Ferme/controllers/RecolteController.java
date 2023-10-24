package com.Dobe.Ferme.controllers;


import com.Dobe.Ferme.dto.PlanteDto;
import com.Dobe.Ferme.dto.RecolteDto;
import com.Dobe.Ferme.services.PlanteService;
import com.Dobe.Ferme.services.RecolteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/recoltes")
public class RecolteController {

    private final RecolteService recolteService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody RecolteDto recolteDto){
        return ResponseEntity.ok(recolteService.save(recolteDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<RecolteDto>> findAll(){
        return ResponseEntity.ok(recolteService.findAll());
    }
    @GetMapping("/{recolteId}")
    public ResponseEntity<RecolteDto> findById(@PathVariable  Integer recolteId){
        return ResponseEntity.ok(recolteService.findById(recolteId));
    }
    @DeleteMapping("/{recolteId}")
    public ResponseEntity<Void> delete(@PathVariable  Integer recolteId ) {
        recolteService.delete(recolteId);
        return ResponseEntity.accepted().build();
    }

}
