package com.salatin.resource.model.dto.request;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class PartCreationRequestDto {
    private String name;
    private String brand;
    private List<String> oemNumbers;
    private BigDecimal price;
    private Integer quantity;
    private String supplier;
}
