package com.Dobe.Ferme.controllers;


import com.Dobe.Ferme.dto.RecolteDto;
import com.Dobe.Ferme.dto.RegimeDto;
import com.Dobe.Ferme.services.RecolteService;
import com.Dobe.Ferme.services.RegimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/regimes")
public class RegimeController {

    private final RegimeService regimeService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody RegimeDto regimeDto){
        return ResponseEntity.ok(regimeService.save(regimeDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<RegimeDto>> findAll(){
        return ResponseEntity.ok(regimeService.findAll());
    }
    @GetMapping("/{regimeId}")
    public ResponseEntity<RegimeDto> findById(@PathVariable  Integer regimeId){
        return ResponseEntity.ok(regimeService.findById(regimeId));
    }
    @DeleteMapping("/{regimeId}")
    public ResponseEntity<Void> delete(@PathVariable Integer regimeId ) {
        regimeService.delete(regimeId);
        return ResponseEntity.accepted().build();
    }

}
