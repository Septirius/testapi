package com.books.example.bookApp.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.books.example.bookApp.business.BookBusiness;
import com.books.example.bookApp.entity.Book;
import com.books.example.bookApp.service.BookService;

@Component
public class BookBusinessImpl implements BookBusiness {
	
	@Autowired
	BookService bookService;
	
	 public List<Book> getBooks() {
	  List<Book> books = bookService.retrieveBooks();
	  return books;
	 }
	  

	 public Book getBook(Long bookId) {
	  return bookService.getBook(bookId);
	 }
	  

	 public void saveBook(Book book){
		 bookService.saveBook(book);
	 }
	  

	 public void deleteBook(Long bookId){
		 bookService.deleteBook(bookId);
	 }
	  
	 
	 public void updateBook( Book book, Long bookId){
		  Book boo = bookService.getBook(bookId);
		  if(boo != null){
			  bookService.updateBook(book);
		  }
	  }
	 
	 public long findBookQuantityByTitle(String title) {
		 return bookService.findBookQuantityByTitle(title);
	 }
	 
	 public void setBookQuantityByTitle(String title, Integer quantity) {
		 bookService.setBookQuantityByTitle(title, quantity);
	 }
	
	 public Optional<Book> findBookByTitle(String title){
		return bookService.findBookByTitle(title);
	 }

}
