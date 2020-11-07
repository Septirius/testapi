package com.books.example.bookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.example.bookApp.business.OrderBusiness;
import com.books.example.bookApp.entity.Order;

@RestController
public class OrderRestController {
	
	@Autowired
	private OrderBusiness orderBusiness;
	
	 public void setOrderBusiness(OrderBusiness orderBusiness) {
		  this.orderBusiness = orderBusiness;
		 }
		 
		 @GetMapping("/api/orders")
		 public List<Order> getOrders() {
		  List<Order> orders = orderBusiness.retrieveOrders();
		  return orders;
		 }
		 
		 @PostMapping("/api/orders/save")
		 public void saveOrder(@RequestBody Order order) {
			 orderBusiness.saveOrder(order);
		 }

}
