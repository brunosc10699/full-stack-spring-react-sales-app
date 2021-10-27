package com.bruno.sds4.resources;

import com.bruno.sds4.dto.SaleDTO;
import com.bruno.sds4.dto.SaleSumDTO;
import com.bruno.sds4.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sales")
@RequiredArgsConstructor
public class SaleResource {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(saleService.findAll(pageable));
    }

    @GetMapping(value = "/byseller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
        return ResponseEntity.ok(saleService.amountGroupedBySeller());
    }

}
