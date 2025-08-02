package com.Saat.Dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoOrderitem {
    private String productIsim;
    private int adet;
    private BigDecimal fiyat;
    private int indirim;
}