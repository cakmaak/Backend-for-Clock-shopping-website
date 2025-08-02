package com.Saat.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "basketitem")
public class BasketItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "adet",nullable = false)
	private int adet;
	
	@Column(name = "fiyat",nullable = false)
	private BigDecimal fiyat;
	
	@Column(name = "indirim")
	private int indirim;
	
	@Column(name = "olusturmatarihi")
	private LocalDateTime olusturmatarihi;
	
	@PrePersist
	protected void onCreate() {
		olusturmatarihi=LocalDateTime.now();
		
	}
	
	@ManyToOne
	@JoinColumn(name = "basket_id")
	private Basket basket;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;


}
