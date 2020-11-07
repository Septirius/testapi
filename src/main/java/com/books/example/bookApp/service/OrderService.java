package com.books.example.bookApp.service;

import java.util.List;

import com.books.example.bookApp.entity.Order;

public interface OrderService {
	
	 public List<Order> retrieveOrders();
	 
	 void setOrderTotalPriceById(String totalPrice, String id );
	  
	 public void saveOrder(Order order);
	  
	 public void deleteOrder(Long Id);
	  
	 public void updateOrder(Order order);

}
