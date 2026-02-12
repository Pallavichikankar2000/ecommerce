package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.repo.ItemRepository;
import com.example.demo.repo.OrderRepository;

@Service
public class OrderService {

	

	 
	    @Autowired
	    private ItemRepository itemRepository;

	    @Autowired
	    private OrderRepository orderRepository;

	    public Order createOrder(Order order) {

	        List<Item> items = order.getItems();

	        List<Item> savedItems = new ArrayList<>();

	        for(Item item : items){
	            Item existingItem = itemRepository.findById(item.getId()).orElse(null);
	            savedItems.add(existingItem);
	        }

	        order.setItems(savedItems);

	        return orderRepository.save(order);
	    }


	    // Get all orders
	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    // Get order by Id
	    public Order getOrderById(Long id) {
	        return orderRepository.findById(id).orElse(null);
	    }

	    // Update order
	    public Order updateOrder(Long id, Order orderDetails) {

	        Order existingOrder = orderRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Order not found"));

	        if(orderDetails.getCustomerName() != null)
	            existingOrder.setCustomerName(orderDetails.getCustomerName());

	        if(orderDetails.getTotalAmount() != null)
	            existingOrder.setTotalAmount(orderDetails.getTotalAmount());

	        if(orderDetails.getStatus() != null)
	            existingOrder.setStatus(orderDetails.getStatus());

	        return orderRepository.save(existingOrder);
	    }



	    // Delete order
	    public void deleteOrder(Long id) {
	        orderRepository.deleteById(id);
	    }
	

}
