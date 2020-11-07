package com.books.example.bookApp.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.books.example.bookApp.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
	
	@Query(value = "SELECT * FROM Books WHERE title = :title", nativeQuery = true)
	public Optional<Book> findBookByTitle(@Param("title") String title);
	
	@Query(value = "SELECT quantity FROM Books WHERE title = :title", nativeQuery = true)
	public long findBookQuantityByTitle(@Param("title") String title);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Books SET quantity = :quantity  WHERE title = :title", nativeQuery = true)
	public void setBookQuantityByTitle(@Param("title") String title, @Param("quantity") Integer quantity);
	

}
