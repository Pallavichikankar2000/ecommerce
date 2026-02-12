package com.example.demo.entity;
	import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

	@Entity
	@Table(name = "orders")
	public class Order {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message="Customer name required")
	    private String customerName;

	    private Double totalAmount;

	    private String status;

	    private LocalDateTime orderDate;

	    
	    @ManyToMany
	    @JoinTable(
	            name = "order_items",
	            joinColumns = @JoinColumn(name = "order_id"),
	            inverseJoinColumns = @JoinColumn(name = "item_id")
	    )
	    private List<Item> items;

	    public Order() {
	    	
	    }
	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public Double getTotalAmount() {
	        return totalAmount;
	    }

	    public void setTotalAmount(Double totalAmount) {
	        this.totalAmount = totalAmount;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public LocalDateTime getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(LocalDateTime orderDate) {
	        this.orderDate = orderDate;
	    }

		public Order(Long id, String customerName, Double totalAmount, String status, LocalDateTime orderDate,
				List<Item> items) {
			super();
			this.id = id;
			this.customerName = customerName;
			this.totalAmount = totalAmount;
			this.status = status;
			this.orderDate = orderDate;
			this.items = items;
		}

		public List<Item> getItems() {
			return items;
		}

		public void setItems(List<Item> items) {
			this.items = items;
		}
	

}
