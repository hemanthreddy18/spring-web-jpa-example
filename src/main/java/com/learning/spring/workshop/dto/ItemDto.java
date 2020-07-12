package com.learning.spring.workshop.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemDto {
    private final int id;
    private final String name;
    private final String description;
    private final ProductDto productDto;
}
