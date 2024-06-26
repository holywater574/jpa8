package com.springboot.jpa_8.data.repository;

import com.springboot.jpa_8.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> getProductList(String name);
    List<Product> getProductListWithPage(int offset, int pageSize);

    List<Product> findProductsByNameOrderByPriceAsc(String name);



}