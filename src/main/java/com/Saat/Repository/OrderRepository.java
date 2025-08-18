package com.Saat.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Saat.Entity.Order;
import com.Saat.Entity.Product;
import com.Saat.Entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByUser(User user);
	

}
