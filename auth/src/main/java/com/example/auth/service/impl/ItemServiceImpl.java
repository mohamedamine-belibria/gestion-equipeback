package com.example.auth.service.impl;

import com.example.auth.modal.Item;
import com.example.auth.repository.ItemRepository;
import com.example.auth.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
   private ItemRepository itemRepository;
    @Override
    public Item findOne(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);

    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);

    }

    @Override
    public List<Item> findByItemType(String itemType) {
        return itemRepository.findByItemType(itemType);
    }
}
