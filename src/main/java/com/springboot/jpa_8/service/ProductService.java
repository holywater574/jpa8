package com.springboot.jpa_8.service;


import com.springboot.jpa_8.data.dto.ProductDto;
import com.springboot.jpa_8.data.dto.ProductResponseDto;

import java.util.List;

// 예제 6.21
public interface ProductService {

    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);
    ProductResponseDto changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;

}