
	package com.example.demo.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.example.demo.entity.Order;
	import com.example.demo.service.OrderService;

import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/api/orders")
	public class OrderController {

	    @Autowired
	    private OrderService orderService;

	    // Create Order
	    @PostMapping
	    public Order createOrder(@Valid @RequestBody Order order) {
	        return orderService.createOrder(order);
	    }

	    // Get All Orders
	    @GetMapping
	    public List<Order> getAllOrders() {
	        return orderService.getAllOrders();
	    }

	    // Get Order By Id
	    @GetMapping("/{id}")
	    public Order getOrderById(@PathVariable Long id) {
	        return orderService.getOrderById(id);
	    }

	    // Update Order
	    @PutMapping("/{id}")
	    public Order updateOrder(@PathVariable Long id,@Valid  @RequestBody Order order) {
	        return orderService.updateOrder(id, order);
	    }

	    // Delete Order
	    @DeleteMapping("/{id}")
	    public String deleteOrder(@PathVariable Long id) {
	        orderService.deleteOrder(id);
	        return "Order deleted successfully!";
	    
	}

}
