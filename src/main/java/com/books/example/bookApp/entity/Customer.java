package com.books.example.bookApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entité représentant un client 
 * @author Utilisateur
 *
 */
@Entity
@Table(name="CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="cust_name") // Nom du client
	private String name;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	} 

	public String getName() {
		return name;     
	}

	public void setName(String name) {
		this.name = name;
	}

}
