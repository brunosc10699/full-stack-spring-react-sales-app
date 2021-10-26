package com.bruno.sds4.services.impl;

import com.bruno.sds4.dto.SaleDTO;
import com.bruno.sds4.repositories.SaleRepository;
import com.bruno.sds4.repositories.SellerRepository;
import com.bruno.sds4.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    private final SellerRepository sellerRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepository.findAll();
        return saleRepository.findAll(pageable).map(SaleDTO::toDTO);
    }
}
