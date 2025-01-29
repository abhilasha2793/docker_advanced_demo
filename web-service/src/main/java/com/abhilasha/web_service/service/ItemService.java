package com.abhilasha.web_service.service;

import com.abhilasha.web_service.model.Item;
import com.abhilasha.web_service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Cacheable(value = "items")  // Cache method result
    public List<Item> getAllItems() {
        System.out.println("Fetching from database...");
        return itemRepository.findAll();
    }

    @CacheEvict(value = "items", allEntries = true)  // Clear cache when new item is added
    public Item addItem(Item item) {
        System.out.println("Adding new item and clearing cache...");
        return itemRepository.save(item);
    }
}
