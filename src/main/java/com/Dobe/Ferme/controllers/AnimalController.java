package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.AlimentDto;
import com.Dobe.Ferme.dto.AnimalDto;
import com.Dobe.Ferme.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/animales")
public class AnimalController {
    private final AnimalService animalService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AnimalDto animalDto){
        return ResponseEntity.ok(animalService.save(animalDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AnimalDto>> findAll() {
        return ResponseEntity.ok(animalService.findAll());
    }

    @GetMapping("/{animalId}")
    public ResponseEntity<AnimalDto> findById(@PathVariable Integer animalId) {
        return ResponseEntity.ok(animalService.findById(animalId));
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<Void> delete(@PathVariable Integer animalId) {
        animalService.delete(animalId);
        return ResponseEntity.accepted().build();
    }
}
