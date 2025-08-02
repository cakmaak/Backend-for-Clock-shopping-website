package com.Saat.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoOrder {
    private Long orderId;
    private LocalDateTime tarih;
    private BigDecimal toplamTutar;
    private String status;
    private List<DtoOrderitem> items;
}