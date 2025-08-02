package com.Saat.Dto;

import java.math.BigDecimal;

import com.Saat.Entity.Basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoBasketitem {
    private Long productId;
    private String productIsim;
    private BigDecimal fiyat;
    private int adet;
    private int indirim;
    private  Long basketid;
}