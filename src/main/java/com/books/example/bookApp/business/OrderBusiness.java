package com.books.example.bookApp.business;

import java.util.List;

import com.books.example.bookApp.entity.Order;

public interface OrderBusiness {
	
	public List<Order> retrieveOrders();
	
	public void saveOrder(Order order);

}
