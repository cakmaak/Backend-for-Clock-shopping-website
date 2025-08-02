package com.Saat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Saat.Entity.BasketItem;

@Repository
public interface BasketitemRepository extends JpaRepository<BasketItem, Long> {

}
