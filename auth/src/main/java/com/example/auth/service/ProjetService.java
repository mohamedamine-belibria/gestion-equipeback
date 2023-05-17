package com.example.auth.service;
import com.example.auth.modal.Projet;
import java.util.List;
import java.util.Optional;

public interface ProjetService {
    Optional<Projet> findOne(Long id);
    List<Projet> findAll();
    Projet save(Projet projet);
    Projet update(Projet projet);
    void delete(Long id);
    void delete(Projet projet);
}