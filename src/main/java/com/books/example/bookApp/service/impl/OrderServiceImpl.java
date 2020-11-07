package com.books.example.bookApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.example.bookApp.entity.Order;
import com.books.example.bookApp.repository.OrderRepository;
import com.books.example.bookApp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	 public List<Order> retrieveOrders() {
		  List<Order> orders = orderRepository.findAll();
		  return orders;
	 }
	 
	 public void saveOrder(Order order) {
		 orderRepository.save(order);
	 }
	 
	 public void setOrderTotalPriceById(String totalPrice, String id ) {
		 orderRepository.setOrderTotalPriceById(totalPrice, id);
	 };
	   
	 public void deleteOrder(Long Id) {
		 orderRepository.deleteById(Id);
	 };
	  
	 public void updateOrder(Order order) {
		 orderRepository.save(order);
	 };

}
