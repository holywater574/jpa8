package com.springboot.jpa_8.data.entity;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;

// 예제 6.6, 예제 6.30, 6.31, 6.32, 6.33, 6.34, 6.35, 6.36, 6.37
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "name")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
