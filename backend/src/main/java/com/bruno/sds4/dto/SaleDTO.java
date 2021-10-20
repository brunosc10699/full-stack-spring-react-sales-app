package com.bruno.sds4.dto;

import com.bruno.sds4.entities.Sale;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Data
@Builder
public class SaleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @EqualsAndHashCode.Exclude
    private Integer visited;

    @EqualsAndHashCode.Exclude
    private Integer deals;

    @EqualsAndHashCode.Exclude
    private BigDecimal amount;

    @EqualsAndHashCode.Exclude
    private LocalDate date;

    @EqualsAndHashCode.Exclude
    private String seller;

    public static SaleDTO toDTO(Sale sale){
        return SaleDTO.builder()
        .id(sale.getId())
        .visited(sale.getVisited())
        .deals(sale.getDeals())
        .amount(sale.getAmount())
        .date(sale.getDate())
        .seller(sale.getSeller().getName())
        .build();
    }
}


