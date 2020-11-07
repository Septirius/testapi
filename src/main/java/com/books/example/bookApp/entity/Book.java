package com.books.example.bookApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entité representant un livre disponible dans le stock
 * @author Utilisateur
 *
 */
@Entity
@Table(name="BOOKS")
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@JsonProperty("title")
	@Column(name="title")      // titre du livre
	private String title;
	
	
	@Column(name="quantity")    //quantité presente dans le stock
	private int quantity;
    
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
