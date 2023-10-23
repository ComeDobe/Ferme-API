package com.Dobe.Ferme.controllers;

import com.Dobe.Ferme.dto.EspeceDto;
import com.Dobe.Ferme.services.EspeceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor

@RequestMapping("/especes")
public class EspeceController {

private  final EspeceService especeService;
    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody EspeceDto especeDto){
        return ResponseEntity.ok(especeService.save(especeDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<EspeceDto>> findAll(){
        return ResponseEntity.ok(especeService.findAll());
    }
    @GetMapping("/{espece-id}")
    public ResponseEntity<EspeceDto> findById(@PathVariable("espece-id") Integer especeId){
        return ResponseEntity.ok(especeService.findById(especeId));
    }
    @DeleteMapping("/{espece-id}")
    public ResponseEntity<Void> delete(@PathVariable ("espece-id") Integer especeId ) {
        especeService.delete(especeId);
        return ResponseEntity.accepted().build();
    }
}
