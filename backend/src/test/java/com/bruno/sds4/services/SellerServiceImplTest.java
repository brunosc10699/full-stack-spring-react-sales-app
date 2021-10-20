package com.bruno.sds4.services;

import com.bruno.sds4.dto.SellerDTO;
import com.bruno.sds4.entities.Seller;
import com.bruno.sds4.repositories.SellerRepository;
import com.bruno.sds4.services.impl.SellerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SellerServiceImplTest {

    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private SellerServiceImpl sellerService;

    private Seller seller = Seller.builder()
            .id("4098435-dfs-ewrei-fsfsdf")
            .name("Hans")
            .build();

    private SellerDTO sellerDTO = SellerDTO.toDTO(seller);

    private PageRequest pageRequest = PageRequest.of(0, 1);

    private Page page = new PageImpl(Collections.singletonList(seller));

    @Test
    @DisplayName("(1) When findAll() is called then return a page of SellerDTO")
    void whenFindAllIsCalledThenReturnAPageOfSellerDTO() {
        when(sellerRepository.findAll(pageRequest)).thenReturn(page);
        Page<SellerDTO> pageSellerDTO = sellerService.findAll(pageRequest);
        assertAll(
                () -> assertThat(pageSellerDTO.getSize(), is(equalTo(1))),
                () -> assertThat(pageSellerDTO.getContent(), is(not(empty()))),
                () -> assertThat(pageSellerDTO.getTotalPages(), is(equalTo(1))),
                () -> assertThat(pageSellerDTO.getContent().get(0), is(equalTo(sellerDTO))),
                () -> assertThat(pageSellerDTO.getTotalElements(), is(equalTo(1L)))
        );
    }

    @Test
    @DisplayName("(2) When findAll() is called return an empty page of SellerDTO")
    void whenFindAllIsCalledThenReturnAnEmptyPage() {
        when(sellerRepository.findAll(pageRequest)).thenReturn(Page.empty());
        Page<SellerDTO> pageSellerDTO = sellerService.findAll(pageRequest);
        assertThat(pageSellerDTO.getContent(), is(empty()));
    }
}
