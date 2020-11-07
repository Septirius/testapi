package com.books.example.bookApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.example.bookApp.entity.Book;
import com.books.example.bookApp.repository.BookRepository;
import com.books.example.bookApp.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	 @Autowired
	 private BookRepository bookRepository;
	 
	 public Optional<Book> findBookByTitle(String title) {
		 return bookRepository.findBookByTitle(title);
	 };
	 
	 public void setBookQuantityByTitle(String title, Integer quantity) {
		 this.bookRepository.setBookQuantityByTitle(title, quantity);
	 };
		
	 public long findBookQuantityByTitle(String title) {
		 return bookRepository.findBookQuantityByTitle(title);
	 };
	 
	 public void setBookRepository(BookRepository bookRepository) {
	  this.bookRepository = bookRepository;
	 }
	  
	 public List<Book> retrieveBooks() {
	  List<Book> books = bookRepository.findAll();
	  return books;
	 }
	  
	 public Book getBook(Long bookId) {
	  Optional<Book> optBook = bookRepository.findById(bookId);
	  return optBook.get();
	 }
	  
	 public void saveBook(Book book){
		 bookRepository.save(book);
	 }
	  
	 public void deleteBook(Long bookId){
		 bookRepository.deleteById(bookId);
	 }
	  
	 public void updateBook(Book book) {
		 bookRepository.save(book);
	 }

}
