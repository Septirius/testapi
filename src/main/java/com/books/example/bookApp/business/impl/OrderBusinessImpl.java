package com.books.example.bookApp.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.books.example.bookApp.business.BookBusiness;
import com.books.example.bookApp.business.OrderBusiness;
import com.books.example.bookApp.entity.Order;
import com.books.example.bookApp.entity.OrderedBook;
import com.books.example.bookApp.service.OrderService;


/**
 * 
 * @author Utilisateur
 *
 */
@Component
public class OrderBusinessImpl implements OrderBusiness{
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	BookBusiness bookBusiness;
	
	public List<Order> retrieveOrders() {
		return orderService.retrieveOrders();
	};
	
	
	/**
	 * Porte des traitements metiers avant persistence de la commande dans la base de données
	 * @param order   commande passée
	 */
	public void saveOrder(Order order) {
		
		List<OrderedBook> books = this.getFinalOrderListAndUpdateStock(order.getOrderedBooks());
		
		Double totalPrice = this.totalOrderPriceCalculus(books);	

		orderService.saveOrder(order);
		
		orderService.setOrderTotalPriceById(totalPrice.toString(), Long.valueOf(order.getId()).toString());
	};
	
	
	
	/**
	 * Ajuste la commnde en fonction des stocks disponibles et met à jour les stocks 
	 * 
	 * @param books             liste de livres commandés originellement
	 * @return finalBookList    liste ajustée des commandes
	 */
	private List<OrderedBook> getFinalOrderListAndUpdateStock (List<OrderedBook> books){
		List<OrderedBook> finalBookList = new ArrayList<>();
		
		for (OrderedBook b : books) {
			// Récupération nombre de livres voulus
			Long orderedQuantity = Long.valueOf(b.getQuantity());
			//Récupération nombre de livres disponibles
			Long availableQuantity = Long.valueOf(bookBusiness.findBookQuantityByTitle(b.getTitle()));
			//calcul de l'ecart entre le nombre de livres voulus et le nombre de livres disponibles
			Long diff = Long.valueOf(availableQuantity - orderedQuantity);
			
			//Mise à jour du stock dans la base de donnée
			if (orderedQuantity >= availableQuantity) {
				bookBusiness.setBookQuantityByTitle(b.getTitle(), Integer.valueOf(0));
				b.setQuantity(availableQuantity.toString());
			}else {
				bookBusiness.setBookQuantityByTitle(b.getTitle(), Integer.valueOf(diff.toString()));
			}
			
			finalBookList.add(b);
		}
		
		return finalBookList;
	}
	
	
	
	/**
	 * Calcule le prix total de la commmande
	 * @param orderedBooks
	 * @return cout total de la commande
	 */
	private Double totalOrderPriceCalculus(List<OrderedBook> orderedBooks) {
		
		return orderedBooks.stream()
				.mapToDouble(b -> Double.valueOf(b.getPrice())*Double.valueOf(b.getQuantity()))
				.sum();
	}

}
