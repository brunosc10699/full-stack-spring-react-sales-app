package com.bruno.sds4.dto;

import com.bruno.sds4.entities.Sale;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SaleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer visited;
    private Integer deals;
    private BigDecimal amount;
    private LocalDate date;
    private String seller;

    public SaleDTO(Sale sale){
        id = sale.getId();
        visited = sale.getVisited();
        deals = sale.getDeals();
        amount = sale.getAmount();
        date = sale.getDate();
        seller = sale.getSeller().getName();
    }
}


