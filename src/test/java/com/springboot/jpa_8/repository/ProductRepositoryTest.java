package com.springboot.jpa_8.repository;

import com.springboot.jpa_8.data.entity.Product;
import com.springboot.jpa_8.data.entity.QProduct;
import com.springboot.jpa_8.data.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void QueryDslTest1() {

        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(5000);
        product2.setStock(300);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(500);
        product3.setStock(50);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product product4 = new Product();
        product4.setName("펜");
        product4.setPrice(1500);
        product4.setStock(250);
        product4.setCreatedAt(LocalDateTime.now());
        product4.setUpdatedAt(LocalDateTime.now());

        Product product5 = new Product();
        product5.setName("펜");
        product5.setPrice(700);
        product5.setStock(300);
        product5.setCreatedAt(LocalDateTime.now());
        product5.setUpdatedAt(LocalDateTime.now());

        Product product6 = new Product();
        product6.setName("공책");
        product6.setPrice(1000);
        product6.setStock(200);
        product6.setCreatedAt(LocalDateTime.now());
        product6.setUpdatedAt(LocalDateTime.now());

        Product product7 = new Product();
        product7.setName("공책");
        product7.setPrice(1200);
        product7.setStock(150);
        product7.setCreatedAt(LocalDateTime.now());
        product7.setUpdatedAt(LocalDateTime.now());

        Product product8 = new Product();
        product8.setName("테이프");
        product8.setPrice(5000);
        product8.setStock(100);
        product8.setCreatedAt(LocalDateTime.now());
        product8.setUpdatedAt(LocalDateTime.now());

        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);

        List<Product> productList = productRepository.getProductList("공책");
        System.out.println(productList);

        List<Product> productListAndPage = productRepository.getProductListWithPage(0,5);
        System.out.println(productListAndPage);
    }

    @Test
    public void queryDSLTest2() {
        QProduct qProduct = QProduct.product;

        // 재고가 100 이상인 모든 제품 찾기
        Iterable<Product> productList = productRepository.findAll(
                qProduct.stock.gt(100)
        );

        for (Product product : productList) {
            System.out.println("Number: " + product.getNumber());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Stock: " + product.getStock());
        }
    }

    @Test
    public void queryDSLTest3() {
        QProduct qProduct = QProduct.product;

        // 이름이 "공"으로 시작하는 모든 제품 찾기
        Iterable<Product> productList = productRepository.findAll(
                qProduct.name.startsWith("공")
        );

        for (Product product : productList) {
            System.out.println("Number: " + product.getNumber());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Stock: " + product.getStock());
        }
    }
}