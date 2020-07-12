package com.learning.spring.workshop.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDto {
    private final int id;
    private final  String name;
    private final  String productType;
    private final ManifacturerDto manifacturer;

}
