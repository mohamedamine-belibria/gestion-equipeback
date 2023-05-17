package com.example.auth.service.impl;

import com.example.auth.modal.Item;
import com.example.auth.modal.ItemDependence;
import com.example.auth.repository.ItemDependenceRepository;
import com.example.auth.service.ItemDependenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ItemDependenceServiceImpl implements ItemDependenceService {
    @Autowired
    private ItemDependenceRepository itemDependenceRepository;
    @Override
    public ItemDependence findOne(Long id) {
        return itemDependenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<ItemDependence> findAll() {
        return itemDependenceRepository.findAll();
    }

    @Override
    public ItemDependence save(ItemDependence itemDependence) {
        return itemDependenceRepository.save(itemDependence);
    }

    @Override
    public ItemDependence update(ItemDependence itemDependence) {
        return itemDependenceRepository.save(itemDependence);
    }

    @Override
    public void delete(Long id) {
        itemDependenceRepository.deleteById(id);

    }

    @Override
    public void delete(ItemDependence itemDependence) {
        itemDependenceRepository.delete(itemDependence);

    }
    @Override
    public List<ItemDependence> findAllTasksPoject(Long projectId) {
        return itemDependenceRepository.findAllTasksProject(projectId);
    }

    @Override
    public Optional<ItemDependence> findBySecondItem(Item taskId) {
        return itemDependenceRepository.findBySecondItem(taskId);
    }
}
