package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;


	import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

	@Entity
	@Table(name = "categories")
	public class Category {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message="Category name required")
	    private String name;

	    @ManyToOne
	    @JoinColumn(name = "parent_id")
	    @JsonBackReference
	    private Category parentCategory;

	    @OneToMany(mappedBy = "parentCategory")
	    @JsonManagedReference
	    private List<Category> subCategories;

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public Category getParentCategory() { return parentCategory; }
	    public void setParentCategory(Category parentCategory) { this.parentCategory = parentCategory; }

	    public List<Category> getSubCategories() { return subCategories; }
	    public void setSubCategories(List<Category> subCategories) { this.subCategories = subCategories; }
	}


