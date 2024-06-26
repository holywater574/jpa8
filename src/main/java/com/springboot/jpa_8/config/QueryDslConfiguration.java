package com.springboot.jpa_8.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDslConfiguration {
    @PersistenceContext
    private EntityManager entityManager;
//@PersistenceContext: 이 어노테이션은 EntityManager의 인스턴스를 주입받기 위해 사용됩니다.
// EntityManager는 JPA(Java Persistence API)의 핵심 인터페이스로, 영속성 컨텍스트와의 상호작용을 담당합니다.

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
