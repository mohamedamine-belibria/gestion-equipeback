package com.example.auth.service;

import com.example.auth.modal.Item;
import com.example.auth.modal.ItemDependence;
import com.example.auth.modal.Tache;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemDependenceService {
    ItemDependence findOne(Long id);
    List<ItemDependence> findAll();
    ItemDependence save(ItemDependence itemDependence);
    ItemDependence update(ItemDependence itemDependence);
    void delete(Long id);
    void delete(ItemDependence itemDependence);
    List<ItemDependence> findAllTasksPoject(Long projectId);
    Optional<ItemDependence> findBySecondItem(Item taskId);
}
