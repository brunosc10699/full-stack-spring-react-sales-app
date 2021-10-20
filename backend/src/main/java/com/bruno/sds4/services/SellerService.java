package com.bruno.sds4.services;

import com.bruno.sds4.dto.SellerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellerService {

    Page<SellerDTO> findAll(Pageable pageable);
}
