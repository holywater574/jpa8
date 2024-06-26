package com.springboot.jpa_8.data.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.jpa_8.data.entity.Product;
import com.springboot.jpa_8.data.entity.QProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Product> getProductList(String name) {
        QProduct qProduct = QProduct.product;
        return jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.name.eq(name))
                .fetch();
    }

    @Override
    public List<Product> getProductListWithPage(int offset, int pageSize) {
        QProduct qProduct = QProduct.product;
        return jpaQueryFactory.selectFrom(qProduct)
                .offset(offset)
                .limit(pageSize)
                .fetch();
    }

    @Override
    public List<Product> findProductsByNameOrderByPriceAsc(String name) {
        QProduct product = QProduct.product;
        return jpaQueryFactory.selectFrom(product)
                .where(product.name.eq(name))
                .orderBy(product.price.asc())
                .fetch();
    }
}
