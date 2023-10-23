package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.MaterielDto;
import com.Dobe.Ferme.dto.ParcelleDto;
import com.Dobe.Ferme.services.MaterielService;
import com.Dobe.Ferme.services.ParcelleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/parcelles")
public class ParcelleController {

    private final ParcelleService parcelleService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody ParcelleDto parcelleDto){
        return ResponseEntity.ok(parcelleService.save(parcelleDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<ParcelleDto>> findAll(){
        return ResponseEntity.ok(parcelleService.findAll());
    }
    @GetMapping("/parcelle-id}")
    public ResponseEntity<ParcelleDto> findById(@PathVariable ("parcelle-id") Integer parcelleId){
        return ResponseEntity.ok(parcelleService.findById(parcelleId));
    }
    @DeleteMapping("/parcelle-id}")
    public ResponseEntity<Void> delete(@PathVariable ("parcelle-id") Integer parcelleId ) {
        parcelleService.delete(parcelleId);
        return ResponseEntity.accepted().build();
    }

}
