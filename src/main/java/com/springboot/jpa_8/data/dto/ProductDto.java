package com.springboot.jpa_8.data.dto;

import lombok.*;

// 예제 6.19
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

    private String name;

    private int price;

    private int stock;

}
