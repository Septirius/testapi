package com.books.example.bookApp.business;

import java.util.List;
import java.util.Optional;

import com.books.example.bookApp.entity.Book;

public interface BookBusiness {
	
	 public List<Book> getBooks();
	 
	 public Book getBook(Long bookId);

	 public void saveBook( Book book);
	 
	 public void deleteBook(Long bookId);
	  
	 public void updateBook( Book book,Long bookId);
	 
	 public Optional<Book> findBookByTitle(String title);
	 
	 public long findBookQuantityByTitle(String title);
	 
	 public void setBookQuantityByTitle(String title, Integer quantity);

}
