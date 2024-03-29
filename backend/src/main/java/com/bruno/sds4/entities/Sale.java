package com.bruno.sds4.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Integer visited;
    private Integer deals;
    private BigDecimal amount;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
