package com.Dobe.Ferme.controllers;


import com.Dobe.Ferme.dto.PlantationDto;
import com.Dobe.Ferme.services.PlantationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/plantations")
public class PlantationController {

    private final PlantationService plantationService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody PlantationDto plantationDto){
        return ResponseEntity.ok(plantationService.save(plantationDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<PlantationDto>> findAll(){
        return ResponseEntity.ok(plantationService.findAll());
    }
    @GetMapping("/{plantationId}")
    public ResponseEntity<PlantationDto> findById(@PathVariable Integer plantationId){
        return ResponseEntity.ok(plantationService.findById(plantationId));
    }
    @DeleteMapping("/{plantationId}")
    public ResponseEntity<Void> delete(@PathVariable  Integer plantationId ) {
        plantationService.delete(plantationId);
        return ResponseEntity.accepted().build();
    }

}
