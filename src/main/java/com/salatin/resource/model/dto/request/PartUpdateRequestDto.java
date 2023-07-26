package com.salatin.resource.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class PartUpdateRequestDto {
    @NotBlank
    private String id;
    @NotBlank
    @Size(min = 5, max = 150)
    private String name;
    @NotBlank
    @Size(min = 2, max = 50)
    private String brand;
    private String number;
    @NotNull
    private List<String> oemNumbers;
    @NotNull
    @PositiveOrZero
    private BigDecimal price;
    @NotNull
    @PositiveOrZero
    private Integer quantity;
    @NotBlank
    @Size(min = 5, max = 50)
    private String supplier;
}
