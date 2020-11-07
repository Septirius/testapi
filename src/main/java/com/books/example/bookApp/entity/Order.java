package com.books.example.bookApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * entité représentant une commande
 * @author Utilisateur
 *
 */
@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="order_number")
	private String orderNumber;        //numero de commande
	
	@Column(name="total_price")
	private double totalPrice;         //prix total de la commande
	
	@OneToMany(targetEntity=OrderedBook.class, cascade = {CascadeType.ALL})
	private List<OrderedBook> orderedBooks;       //liste de livres commandés
	
	@ManyToOne(targetEntity=Customer.class, cascade = {CascadeType.ALL})
	private Customer customer;                   //client ayant passé commande

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderedBook> getOrderedBooks() {
		return orderedBooks;
	}

	public void setOrderedBooks(List<OrderedBook> orderedBooks) {
		this.orderedBooks = orderedBooks;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



}
