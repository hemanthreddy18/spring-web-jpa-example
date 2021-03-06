package com.learning.spring.workshop.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ManifacturerDto {
    private final int id;
    private final String name;
}
