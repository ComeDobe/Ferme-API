package com.Dobe.Ferme.controllers;


import com.Dobe.Ferme.dto.RegimeDto;
import com.Dobe.Ferme.dto.TacheDto;
import com.Dobe.Ferme.services.RegimeService;
import com.Dobe.Ferme.services.TacheService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taches")
@Tag(name = "taches")

public class TacheController {

    private final TacheService tacheService;
    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody TacheDto tacheDto){
        return ResponseEntity.ok(tacheService.save(tacheDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<TacheDto>> findAll(){
        return ResponseEntity.ok(tacheService.findAll());
    }
    @GetMapping("/{tacheId}")
    public ResponseEntity<TacheDto> findById(@PathVariable Integer tacheId){
        return ResponseEntity.ok(tacheService.findById(tacheId));
    }
    @DeleteMapping("/{tacheId}")
    public ResponseEntity<Void> delete(@PathVariable  Integer tacheId ) {
        tacheService.delete(tacheId);
        return ResponseEntity.accepted().build();
    }

}
