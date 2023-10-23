package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.AlimentDto;
import com.Dobe.Ferme.dto.FermeDto;
import com.Dobe.Ferme.services.AlimentService;
import com.Dobe.Ferme.services.FermeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/fermes")
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
    @GetMapping("/{ferme-id}")
    public ResponseEntity<FermeDto> findById(@PathVariable ("ferme-id") Integer fermeId){
        return ResponseEntity.ok(fermeService.findById(fermeId));
    }
    @DeleteMapping("/{ferme-id}")
    public ResponseEntity<Void> delete(@PathVariable ("ferme-id") Integer fermeId ) {
        fermeService.delete(fermeId);
        return ResponseEntity.accepted().build();
    }

}
