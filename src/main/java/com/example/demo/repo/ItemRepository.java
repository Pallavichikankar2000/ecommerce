package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findByNameContaining(String name);

	List<Item> findByPriceLessThan(Double price);

	List<Item> findByPriceBetween(Double min, Double max);

}
