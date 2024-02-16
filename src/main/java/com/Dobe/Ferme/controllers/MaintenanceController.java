package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.AlimentDto;
import com.Dobe.Ferme.dto.MaintenanceDto;
import com.Dobe.Ferme.services.AlimentService;
import com.Dobe.Ferme.services.MaintenanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenances")
@Tag(name = "maintenances")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @PostMapping("/")
    public ResponseEntity <Integer> save(@RequestBody MaintenanceDto maintenanceDto){
        return ResponseEntity.ok(maintenanceService.save(maintenanceDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<MaintenanceDto>> findAll(){
        return ResponseEntity.ok(maintenanceService.findAll());
    }
    @GetMapping("/{maitenanceId}")
    public ResponseEntity<MaintenanceDto> findById(@PathVariable Integer maintenanceId){
        return ResponseEntity.ok(maintenanceService.findById(maintenanceId));
    }
    @DeleteMapping("/{maitenanceId}")
    public ResponseEntity<Void> delete(@PathVariable  Integer maintenanceId ) {
        maintenanceService.delete(maintenanceId);
        return ResponseEntity.accepted().build();
    }

}
