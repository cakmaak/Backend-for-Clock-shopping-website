package com.Saat.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Saat.Entity.Basket;
import com.Saat.Entity.User;


@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
	
	Optional<Basket> findByUser(User user);

}
