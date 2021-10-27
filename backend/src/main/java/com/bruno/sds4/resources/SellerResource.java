package com.bruno.sds4.resources;

import com.bruno.sds4.dto.SellerDTO;
import com.bruno.sds4.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/sellers")
@RequiredArgsConstructor
public class SellerResource {

    private final SellerService sellerService;

    @GetMapping
    public ResponseEntity<Page<SellerDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(sellerService.findAll(pageable));
    }

}
