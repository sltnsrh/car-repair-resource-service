package com.salatin.resource.model.dto.response;

import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;

@Data
public class PartResponseDto {
    private String id;
    private String name;
    private String brand;
    private String number;
    private Set<String> oemNumbers;
    private BigDecimal price;
    private Integer quantity;
    private String supplier;
    private String lastUpdatedAt;
}
