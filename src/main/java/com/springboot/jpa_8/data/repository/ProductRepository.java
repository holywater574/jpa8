package com.springboot.jpa_8.data.repository;


import com.springboot.jpa_8.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

// 예제 6.7
public interface ProductRepository extends JpaRepository<Product, Long>
        ,ProductRepositoryCustom, QuerydslPredicateExecutor<Product> {
    @Query("select p from Product p where p.name =?1")
    List<Product> findByProductName(String name);
    @Query("select p from Product p where p.name= :name")
    List<Product> findByProductName2(String name);
    List<Product> findByName(String name, Sort sort);
    Page<Product> findByName(String name, Pageable pageable);
}
