package com.bruno.sds4.dto;

import com.bruno.sds4.entities.Seller;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class SuccessRateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sellerName;
    private Long deals;
    private Long visited;

    public SuccessRateDTO(Seller sellerName, Long deals, Long visited) {
        this.sellerName = sellerName.getName();
        this.deals = deals;
        this.visited = visited;
    }
}
