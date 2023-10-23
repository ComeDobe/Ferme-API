package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.AlimentDto;
import com.Dobe.Ferme.dto.MaintenanceDto;
import com.Dobe.Ferme.services.AlimentService;
import com.Dobe.Ferme.services.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/maintenances")
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
    @GetMapping("/{maitenance-id}")
    public ResponseEntity<MaintenanceDto> findById(@PathVariable ("maintenance-id") Integer maintenanceId){
        return ResponseEntity.ok(maintenanceService.findById(maintenanceId));
    }
    @DeleteMapping("/{maitenance-id}")
    public ResponseEntity<Void> delete(@PathVariable ("maintenance-id") Integer maintenanceId ) {
        maintenanceService.delete(maintenanceId);
        return ResponseEntity.accepted().build();
    }

}
