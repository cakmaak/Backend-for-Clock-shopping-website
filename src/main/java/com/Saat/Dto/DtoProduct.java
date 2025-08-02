package com.Saat.Dto;

import java.math.BigDecimal;

import com.Saat.Enums.Category;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoProduct {
    
    private String isim;
    private BigDecimal fiyat;
    private String url;
    private int indirim;
    @Enumerated(EnumType.STRING)
	 private Category category;
    private String model;
    private String marka;
    private String aciklama;
    
}