package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.AlimentDto;
import com.Dobe.Ferme.dto.UtilisateurDto;
import com.Dobe.Ferme.repositories.AlimentRepository;
import com.Dobe.Ferme.services.AlimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/aliment")
public class AlimentController {

    public final AlimentService alimentService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody AlimentDto alimentDto){
        return ResponseEntity.ok(alimentService.save(alimentDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<AlimentDto>> findAll(){
        return ResponseEntity.ok(alimentService.findAll());
    }
    @GetMapping("/{aliment-id}")
    public ResponseEntity<AlimentDto> findById(@PathVariable ("aliment-id") Integer alimentId){
        return ResponseEntity.ok(alimentService.findById(alimentId));
    }
    @DeleteMapping("/{aliment-id}")
    public ResponseEntity<Void> delete(@PathVariable ("aliment-id") Integer alimentId ) {
        alimentService.delete(alimentId);
        return ResponseEntity.accepted().build();
    }

}
