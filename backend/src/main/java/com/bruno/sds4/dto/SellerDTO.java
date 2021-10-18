package com.bruno.sds4.dto;

import com.bruno.sds4.entities.Seller;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @NotBlank(message = "This field is required")
    private String name;

    public SellerDTO (Seller seller){
        id = seller.getId();
        name = seller.getName();
    }
}













