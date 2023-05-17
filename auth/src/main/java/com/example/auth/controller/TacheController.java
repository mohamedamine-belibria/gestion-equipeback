package com.example.auth.controller;
import com.example.auth.modal.Tache;
import com.example.auth.service.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RequiredArgsConstructor
@RestController

public class TacheController {
    @Autowired
    private TacheService tacheService;

    @PostMapping(path = "/savetache")
    public Tache savetache(@RequestBody Tache tache) {
        return tacheService.save(tache);
    }

    @GetMapping(path = "/getalltaches")
    public List<Tache> getTaches() {
        return tacheService.findAll();
    }

    @GetMapping(path = "/getTache/{id}")
    public Optional<Tache> getTache(@PathVariable Long id) {
        return tacheService.findOne(id);
    }
    @DeleteMapping(path = "/deletetache/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        tacheService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/updatetache")
    public Tache updateTache(@RequestBody Tache tache) {
        return tacheService.update(tache);
    }
}