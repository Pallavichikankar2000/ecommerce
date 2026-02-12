package com.example.demo.service;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.demo.entity.Category;
	import com.example.demo.repo.CategoryRepository;

	@Service
	public class CategoryService {

	    @Autowired
	    private CategoryRepository categoryRepository;

	    // Create category
	    public Category saveCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    // Get all categories
	    public List<Category> getAllCategories() {
	        return categoryRepository.findAll();
	    }

	    // Get category by id
	    public Category getCategoryById(Long id) {
	        return categoryRepository.findById(id).orElse(null);
	    }

	    // Update category
	    public Category updateCategory(Long id, Category category) {
	        category.setId(id);
	        return categoryRepository.save(category);
	    }

	    // Delete category
	    public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }
	

}
