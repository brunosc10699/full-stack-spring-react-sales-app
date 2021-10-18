package com.bruno.sds4.services;

import com.bruno.sds4.dto.SellerDTO;
import com.bruno.sds4.repositories.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SellerDTO> findAll(Pageable pageable){
        return sellerRepository.findAll(pageable).map(SellerDTO::new);
    }
}
