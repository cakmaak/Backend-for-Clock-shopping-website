package com.Saat.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Saat.Entity.OrderItem;


@Repository
public interface OrderitemRepository extends JpaRepository<OrderItem, Long> {
	
	

}
