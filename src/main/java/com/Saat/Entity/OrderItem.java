package com.Saat.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name="orderitem",schema = "clock")
public class OrderItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "adet",nullable = false)
	private int adet;
	
	@Column(name = "toplamfiyat",nullable = false)
	private BigDecimal toplamfiyat;
	
	@Column(name = "eklenmetarihi",nullable = false)
	private LocalDateTime eklenmetarihi;
	
	@Column(name = "indirim")
	private int indirim;
	
	@PrePersist
	protected void oncreate() {
		eklenmetarihi=LocalDateTime.now();
	}
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order ;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	
	
}
