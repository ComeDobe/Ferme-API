package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.ProductionDto;
import com.Dobe.Ferme.services.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/productions")
public class ProductionController {

    private final ProductionService productionService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody ProductionDto productionDto){
        return ResponseEntity.ok(productionService.save(productionDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<ProductionDto>> findAll(){
        return ResponseEntity.ok(productionService.findAll());
    }
    @GetMapping("/{production-id}")
    public ResponseEntity<ProductionDto> findById(@PathVariable ("production-id") Integer productionId){
        return ResponseEntity.ok(productionService.findById(productionId));
    }
    @DeleteMapping("/{production-id}")
    public ResponseEntity<Void> delete(@PathVariable ("production-id") Integer productionId ) {
        productionService.delete(productionId);
        return ResponseEntity.accepted().build();
    }

}
