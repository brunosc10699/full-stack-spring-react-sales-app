package com.bruno.sds4.services;

import com.bruno.sds4.dto.SaleDTO;
import com.bruno.sds4.dto.SaleSumDTO;
import com.bruno.sds4.dto.SuccessRateDTO;
import com.bruno.sds4.entities.Sale;
import com.bruno.sds4.entities.Seller;
import com.bruno.sds4.repositories.SaleRepository;
import com.bruno.sds4.repositories.SellerRepository;
import com.bruno.sds4.services.impl.SaleServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SaleServiceImplTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private SaleServiceImpl saleService;

    private Seller seller = Seller.builder()
            .id("dlj345-slfjd-sdf034-dfsdf")
            .name("Karl")
            .build();

    private Sale sale = Sale.builder()
            .id("dkf98d-dfsf-dfklw84-dfsd")
            .seller(seller)
            .deals(1500)
            .amount(BigDecimal.valueOf(100000.0))
            .date(LocalDate.parse("2021-10-20"))
            .visited(1500)
            .build();

    private SaleDTO saleDTO = SaleDTO.toDTO(sale);

    private PageRequest pageRequest = PageRequest.of(0, 1);

    private Page page = new PageImpl(Collections.singletonList(sale));

    @Test
    @DisplayName("(1) When findAll() is called then return a page of SaleDTO")
    void whenFindAllIsCalledThenReturnAPageOfSaleDTO() {
        when(saleRepository.findAll(pageRequest)).thenReturn(page);
        Page<SaleDTO> pageSaleDTO = saleService.findAll(pageRequest);
        assertAll(
                () -> assertThat(pageSaleDTO.getContent(), is(not(empty()))),
                () -> assertThat(pageSaleDTO.getContent().get(0), is(equalTo(saleDTO))),
                () -> assertThat(pageSaleDTO.getTotalElements(), is(equalTo(1L))),
                () -> assertThat(pageSaleDTO.getTotalPages(), is(equalTo(1))),
                () -> assertThat(pageSaleDTO.getSize(), is(equalTo(1)))
        );
    }

    @Test
    @DisplayName("(2) When findAll() is called then return an empty page")
    void whenFindAllIsCalledThenReturnAnEmptyPage() {
        when(saleRepository.findAll(pageRequest)).thenReturn(Page.empty());
        Page<SaleDTO> pageSaleDTO = saleService.findAll(pageRequest);
        assertThat(pageSaleDTO.getContent(), is(empty()));
    }

    @Test
    @DisplayName("(3) When amountGroupedBySeller() is called then return a list")
    void whenAmountGroupedBySellerIsCalledThenReturnAList() {
        SaleSumDTO saleSumDTO = new SaleSumDTO(seller, sale.getAmount());
        when(saleRepository.amountGroupedBySeller()).thenReturn(Collections.singletonList(saleSumDTO));
        List<SaleSumDTO> report = saleService.amountGroupedBySeller();
        assertAll(
                () -> assertThat(report.get(0).getAmount(), is(equalTo(BigDecimal.valueOf(100000.0)))),
                () -> assertThat(report.get(0).getSellerName(), is(equalTo("Karl")))
        );
    }

    @Test
    @DisplayName("(4) When successRateGroupedBySeller() is called then return a list")
    void whenSuccessRateGroupedBySellerIsCalledThenReturnAList() {
        SuccessRateDTO successRateDTO = new SuccessRateDTO(seller, 800L, 1000L);
        when(saleRepository.successRateGroupedBySeller()).thenReturn(Collections.singletonList(successRateDTO));
        List<SuccessRateDTO> list = saleService.successRateGroupedBySeller();
        assertAll(
                () -> assertThat(list, is(not(empty()))),
                () -> assertThat(list.get(0).getSellerName(), is(equalTo(successRateDTO.getSellerName()))),
                () -> assertThat(list.get(0).getDeals(), is(equalTo(successRateDTO.getDeals()))),
                () -> assertThat(list.get(0).getVisited(), is(equalTo(successRateDTO.getVisited())))
        );
    }
}
