package com.example.auth.service.impl;
import com.example.auth.modal.Tache;
import com.example.auth.repository.TacheRepository;
import com.example.auth.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TacheServiceImpl implements TacheService {
    @Autowired
    TacheRepository repository;

    @Override
    public Optional<Tache> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Tache> findAll() {
        return repository.findAll();
    }

    @Override
    public Tache save(Tache tache) {
        return repository.save(tache);
    }

    @Override
    public Tache update(Tache tache) {
        repository.save(tache);
        return tache;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Tache tache) {
        repository.delete(tache);
    }
}

