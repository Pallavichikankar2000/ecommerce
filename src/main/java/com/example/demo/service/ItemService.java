package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.repo.ItemRepository;

@Service
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;
 
    @Autowired
    private CategoryRepository categoryRepository;
    // Create Item
//    public Item saveItem(Item item) {
//        return itemRepository.save(item);
//    }

    
    public Item createItem(Item item) {

        if (item.getCategory() == null || item.getCategory().getId() == null) {
            throw new RuntimeException("Category id must be provided");
        }

        Long categoryId = item.getCategory().getId();

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        item.setCategory(category);

        return itemRepository.save(item);
    }


    // Get All Items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get Item By Id
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
    // Delete Item
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
    
    //update item
    public Item updateItem(Long id, Item item) {
        item.setId(id);
        return itemRepository.save(item);
    }
    public List<Item> searchByName(String name) {
        return itemRepository.findByNameContaining(name);
    }

    public List<Item> searchByPriceLessThan(Double price) {
        return itemRepository.findByPriceLessThan(price);
    }

    public List<Item> searchByPriceRange(Double min, Double max) {
        return itemRepository.findByPriceBetween(min, max);
    }

}
