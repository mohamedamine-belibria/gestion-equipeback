package com.example.auth.service;
import com.example.auth.modal.Tache;
import java.util.List;
import java.util.Optional;

public interface TacheService {
    Optional<Tache> findOne(Long id);
    List<Tache> findAll();
    Tache save(Tache tache);
    Tache update(Tache tache);
    void delete(Long id);
    void delete(Tache tache);
}
