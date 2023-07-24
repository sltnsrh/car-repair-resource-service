package com.salatin.resource.model.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PartCreationDto {
    private String name;
    private String brand;
    private Integer oemNumber;
    private BigDecimal price;
    private Integer quantity;
    private String supplier;
}
