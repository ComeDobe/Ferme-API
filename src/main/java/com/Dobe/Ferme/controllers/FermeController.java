package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.AlimentDto;
import com.Dobe.Ferme.dto.FermeDto;
import com.Dobe.Ferme.services.AlimentService;
import com.Dobe.Ferme.services.FermeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fermes")
@Tag(name = "fermes")
public class FermeController {

    private final FermeService fermeService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody FermeDto fermeDto){
        return ResponseEntity.ok(fermeService.save(fermeDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<FermeDto>> findAll(){
        return ResponseEntity.ok(fermeService.findAll());
    }
    @GetMapping("/{fermeId}")
    public ResponseEntity<FermeDto> findById(@PathVariable Integer fermeId){
        return ResponseEntity.ok(fermeService.findById(fermeId));
    }
    @DeleteMapping("/{fermeId}")
    public ResponseEntity<Void> delete(@PathVariable  Integer fermeId ) {
        fermeService.delete(fermeId);
        return ResponseEntity.accepted().build();
    }

}
