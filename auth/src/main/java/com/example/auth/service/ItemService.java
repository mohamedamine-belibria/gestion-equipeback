package com.example.auth.service;

import com.example.auth.modal.Item;
import com.example.auth.modal.Projet;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item findOne(Long id);
    List<Item> findAll();
    Item save(Item item);
    Item update(Item item);
    void delete(Long id);
    void delete(Item item);
    List<Item> findByItemType(String itemType);
}
