package com.bruno.sds4.resources;

import com.bruno.sds4.dto.SaleDTO;
import com.bruno.sds4.entities.Sale;
import com.bruno.sds4.entities.Seller;
import com.bruno.sds4.services.impl.SaleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class SaleResourceTest {

    private static final String URN = "/api/v1/sales/";

    @Mock
    private SaleServiceImpl saleService;

    @InjectMocks
    private SaleResource saleResource;

    private MockMvc mockMvc;

    private Seller seller = Seller.builder()
            .id("dje08f-349jhf-454gore-9rj")
            .name("Hans")
            .build();

    private Sale sale = Sale.builder()
            .id("dljdfs-34nf-4kl35-idfu03")
            .visited(100)
            .date(LocalDate.parse("2021-10-20"))
            .amount(new BigDecimal(5000))
            .deals(100)
            .seller(seller)
            .build();

    private SaleDTO saleDTO = SaleDTO.toDTO(sale);

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(saleResource)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    @DisplayName("(1) When findAll() is called then return 200 OK status")
    void whenFindAllIsCalledThenReturn200OkStatus() throws Exception {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<SaleDTO> pageSaleDTO = new PageImpl(Collections.singletonList(saleDTO));
        when(saleService.findAll(pageRequest)).thenReturn(pageSaleDTO);
        mockMvc.perform(MockMvcRequestBuilders.get(URN)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
