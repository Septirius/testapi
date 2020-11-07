package com.books.example.bookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.books.example.bookApp.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE orders SET total_price = :totalPrice  WHERE id = :id", nativeQuery = true)
	public void setOrderTotalPriceById(@Param("totalPrice") String totalPrice, @Param("id") String id );

}
