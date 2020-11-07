package com.books.example.bookApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entité représentant un des livres commandé
 * @author Utilisateur
 *
 */
@Entity
@Table(name="ORDERED_BOOKS")
public class OrderedBook {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title")   //titre du livre
	private String title;
	
	@Column(name="price")     //prix du livre
	private String price;
	
	@Column(name="quantity")  //nombre de livres commandés
	private String quantity;

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
