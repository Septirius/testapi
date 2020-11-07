package com.books.example.bookApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.example.bookApp.business.BookBusiness;
import com.books.example.bookApp.entity.Book;

@RestController
public class BookRestController {
	
	@Autowired
	 private BookBusiness bookBusiness;
	  
	 public void setBookService(BookBusiness bookBusiness) {
	  this.bookBusiness = bookBusiness;
	 }
	 
	 @GetMapping("/api/books")
	 public List<Book> getBooks() {
	  List<Book> books = bookBusiness.getBooks();
	  return books;
	 }
	  
	 @GetMapping("/api/books/{bookId}")
	 public Book getBook(@PathVariable(name="bookId")Long bookId) {
	  return bookBusiness.getBook(bookId);
	 }
	  
	 @PostMapping("/api/books/save")
	 public void saveBook( @RequestBody Book book){
		 bookBusiness.saveBook(book);
	  System.out.println("Book Saved Successfully");
	 }
	  
	 @DeleteMapping("/api/books/{bookId}")
	 public void deleteBook(@PathVariable(name="bookId")Long bookId){
		 bookBusiness.deleteBook(bookId);
	  System.out.println("Book Deleted Successfully");
	 }
	  
	 @PutMapping("/api/books/{bookId}")
	 public void updateBook( Book book, @PathVariable(name="bookId")Long bookId){
	  Book boo = bookBusiness.getBook(bookId);
	  if(boo != null){
		  bookBusiness.updateBook(book, bookId);
	  }
	   
	 }
	 
	 @RequestMapping(value = "/api/books/{title}")
	 public Book findBookByTitle(@RequestParam(value="title") String title){
		 Optional<Book> optBook =  bookBusiness.findBookByTitle(title);
		 return optBook.get();
	 }

}
