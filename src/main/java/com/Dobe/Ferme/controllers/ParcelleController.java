package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.MaterielDto;
import com.Dobe.Ferme.dto.ParcelleDto;
import com.Dobe.Ferme.services.MaterielService;
import com.Dobe.Ferme.services.ParcelleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parcelles")
@Tag(name = "parcelles")
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
    @GetMapping("/{parcelleId}")
    public ResponseEntity<ParcelleDto> findById(@PathVariable Integer parcelleId){
        return ResponseEntity.ok(parcelleService.findById(parcelleId));
    }
    @DeleteMapping("/{parcelleId}")
    public ResponseEntity<Void> delete(@PathVariable  Integer parcelleId ) {
        parcelleService.delete(parcelleId);
        return ResponseEntity.accepted().build();
    }

}
