package com.Saat.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.Saat.Enums.Category;
import com.Saat.Enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products",schema = "clock")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	@Column(nullable = false,name = "isim")
	 private String isim;
	 
	@Column(nullable = false,name = "aciklama")
	 private String aciklama;
	 
	@Column(nullable = false,name = "fiyat")
	 private BigDecimal fiyat;
	 
	@Column(name = "marka")
	 private String marka;
	 
	@Column(nullable = false,name = "model")
	 private String model;
	 
	
	@Column(name = "stok")
	 private int stok;
	 
	@Column(name = "url")
	 private String url;
	 
	@Column(name = "indirim")
	 private int indirim;
	 
	
	@Column(name = "puan")
	 private Double puan;


	@Column(nullable = false,name = "eklenmetarihi")
	 private LocalDateTime eklenmetarihi;
	 
	 
	 @Enumerated(EnumType.STRING)
	 @Column(nullable = false,name = "cinsiyet")
	 private Gender cinsiyet;
	 
	 @Column(name = "kategori")
	 @Enumerated(EnumType.STRING)
	 private Category category;
	 
	 @PrePersist
	 protected void oncreate() {
		 eklenmetarihi=LocalDateTime.now();
		
	}
	 
	 
	 

}
