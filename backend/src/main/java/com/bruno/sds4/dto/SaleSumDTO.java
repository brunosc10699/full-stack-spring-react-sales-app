package com.bruno.sds4.dto;

import com.bruno.sds4.entities.Seller;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class SaleSumDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sellerName;
    private BigDecimal amount;

    public SaleSumDTO(Seller seller, BigDecimal amount) {
        this.sellerName = seller.getName();
        this.amount = amount;
    }
}
