package com.example.auth.service.impl;
import com.example.auth.modal.Projet;
import com.example.auth.repository.ProjetRepository;
import com.example.auth.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements ProjetService {
    @Autowired
    ProjetRepository repository;

    @Override
    public Optional<Projet> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Projet> findAll() {
        return repository.findAll();
    }

    @Override
    public Projet save(Projet projet) {
        return repository.save(projet);
    }

    @Override
    public Projet update(Projet projet) {
        return repository.save(projet);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Projet projet) {
        repository.delete(projet);
    }
}

