package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.AlimentDto;
import com.Dobe.Ferme.dto.UtilisateurDto;
import com.Dobe.Ferme.repositories.AlimentRepository;
import com.Dobe.Ferme.services.AlimentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aliments")
@Tag(name = "aliments")
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
    @GetMapping("/{alimentId}")
    public ResponseEntity<AlimentDto> findById(@PathVariable Integer alimentId){
        return ResponseEntity.ok(alimentService.findById(alimentId));
    }
    @DeleteMapping("/{alimentId}")
    public ResponseEntity<Void> delete(@PathVariable Integer alimentId ) {
        alimentService.delete(alimentId);
        return ResponseEntity.accepted().build();
    }

}
