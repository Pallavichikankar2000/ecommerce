

	package com.example.demo.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.example.demo.entity.Category;
	import com.example.demo.service.CategoryService;

import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/api/categories")
	public class CategoryController {

	    @Autowired
	    private CategoryService categoryService;

	    // Create category
	    @PostMapping
	    public Category createCategory(@Valid @RequestBody Category category) {
	        return categoryService.saveCategory(category);
	    }

	    // Get all categories
	    @GetMapping
	    public List<Category> getAllCategories() {
	        return categoryService.getAllCategories();
	    }

	    // Get category by id
	    @GetMapping("/{id}")
	    public Category getCategoryById(@PathVariable Long id) {
	        return categoryService.getCategoryById(id);
	    }

	    // Update category
	    @PutMapping("/{id}")
	    public Category updateCategory(@PathVariable Long id,@Valid @RequestBody Category category) {
	        return categoryService.updateCategory(id, category);
	    }

	    // Delete category
	    @DeleteMapping("/{id}")
	    public String deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategory(id);
	        return "Category deleted successfully!";
	    }
	

}
