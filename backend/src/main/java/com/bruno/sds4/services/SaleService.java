package com.bruno.sds4.services;

import com.bruno.sds4.dto.SaleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SaleService {

    Page<SaleDTO> findAll(Pageable pageable);
}
