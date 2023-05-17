package com.example.auth.controller;
import com.example.auth.modal.Projet;
import com.example.auth.service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RequiredArgsConstructor
@RestController

public class ProjetController {
    @Autowired
    private ProjetService projetService;

    @PostMapping(path = "/saveprojet")
    public Projet saveprojet(@RequestBody Projet projet) {
        return projetService.save(projet);
    }

    @GetMapping(path = "/getallprojets")
    public List<Projet> getProjets() {
        return projetService.findAll();
    }

    @GetMapping(path = "/getprojet/{id}")
    public Optional<Projet> getProjet(@PathVariable Long id) {
        return projetService.findOne(id);
    }

    @DeleteMapping(path = "/projet/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        projetService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/updateprojet")
    public Projet updateProjet(@RequestBody Projet projet) {
        return projetService.update(projet);
    }
}

