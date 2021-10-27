package com.bruno.sds4.services;

import com.bruno.sds4.dto.SaleDTO;
import com.bruno.sds4.dto.SaleSumDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleService {

    Page<SaleDTO> findAll(Pageable pageable);

    List<SaleSumDTO> amountGroupedBySeller();

}
