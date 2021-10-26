package com.bruno.sds4.dto;

import com.bruno.sds4.entities.Sale;
import com.bruno.sds4.entities.Seller;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Data
@Builder
public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @EqualsAndHashCode.Exclude
    @NotBlank(message = "This field is required")
    private String name;

    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<SaleDTO> sales = new ArrayList<>();

    public static SellerDTO toDTO(Seller seller) {
        return SellerDTO.builder()
                .id(seller.getId())
                .name(seller.getName())
                .sales(seller.getSales().stream().map(SaleDTO::toDTO).collect(Collectors.toList()))
                .build();
    }

}













