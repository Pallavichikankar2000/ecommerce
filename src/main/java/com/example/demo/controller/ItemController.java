package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/items")

public class ItemController {
	    @Autowired
	    private ItemService itemService;

	    // Create Item
	    @PostMapping
	    public Item createItem(@Valid @RequestBody Item item) {
	        return itemService.createItem(item);
	    }

	    // Get All Items
	    @GetMapping
	    public List<Item> getAllItems() {
	        return itemService.getAllItems();
	    }

	    // Get Item By Id
	    @GetMapping("/{id}")
	    public Item getItemById(@PathVariable Long id) {
	        return itemService.getItemById(id);
	    }

	    // Delete Item
	    @DeleteMapping("/{id}")
	    public String deleteItem(@PathVariable Long id) {
	        itemService.deleteItem(id);
	        return "Item deleted successfully!";
	    }
	
	    @PutMapping("/{id}")
	    public Item updateItem(@PathVariable Long id, @Valid @RequestBody Item item) {
	        return itemService.updateItem(id, item);
	    }

	    @GetMapping("/search/name")
	    public List<Item> searchByName(@RequestParam String name) {
	        return itemService.searchByName(name);
	    }

	    @GetMapping("/search/price-less-than")
	    public List<Item> searchByPriceLessThan(@RequestParam Double price) {
	        return itemService.searchByPriceLessThan(price);
	    }

	    @GetMapping("/search/price-range")
	    public List<Item> searchByPriceRange(
	            @RequestParam Double min,
	            @RequestParam Double max) {
	        return itemService.searchByPriceRange(min, max);
	    }



}
