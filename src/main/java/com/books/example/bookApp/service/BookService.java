package com.books.example.bookApp.service;

import java.util.List;
import java.util.Optional;

import com.books.example.bookApp.entity.Book;


public interface BookService {
	
	 public List<Book> retrieveBooks();
	  
	 public Book getBook(Long bookId);
	  
	 public void saveBook(Book book);
	  
	 public void deleteBook(Long bookId);
	  
	 public void updateBook(Book book);
		
	 public Optional<Book> findBookByTitle(String title);
		
	 public long findBookQuantityByTitle(String title);
	 
	 void setBookQuantityByTitle(String title, Integer quantity);

}
