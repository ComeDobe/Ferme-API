package com.Dobe.Ferme.controllers;


import com.Dobe.Ferme.dto.PlantationDto;
import com.Dobe.Ferme.dto.PlanteDto;
import com.Dobe.Ferme.services.PlantationService;
import com.Dobe.Ferme.services.PlanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody PlanteDto planteDto){
        return ResponseEntity.ok(planteService.save(planteDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<PlanteDto>> findAll(){
        return ResponseEntity.ok(planteService.findAll());
    }
    @GetMapping("/{planteId}")
    public ResponseEntity<PlanteDto> findById(@PathVariable Integer planteId){
        return ResponseEntity.ok(planteService.findById(planteId));
    }
    @DeleteMapping("/{planteId}")
    public ResponseEntity<Void> delete(@PathVariable  Integer planteId ) {
        planteService.delete(planteId);
        return ResponseEntity.accepted().build();
    }

}
