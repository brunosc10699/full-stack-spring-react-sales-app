package com.bruno.sds4.repositories;

import com.bruno.sds4.dto.SaleSumDTO;
import com.bruno.sds4.dto.SuccessRateDTO;
import com.bruno.sds4.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {

    @Query("SELECT new com.bruno.sds4.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
            " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.bruno.sds4.dto.SuccessRateDTO(obj.seller, SUM(obj.deals), SUM(obj.visited)) " +
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SuccessRateDTO> successRateGroupedBySeller();
}
