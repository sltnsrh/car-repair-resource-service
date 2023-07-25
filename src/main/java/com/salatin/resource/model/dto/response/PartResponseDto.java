package com.salatin.resource.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Data
public class PartResponseDto {
    private String id;
    private String name;
    private String brand;
    private Set<String> oemNumbers;
    private BigDecimal price;
    private Integer quantity;
    private String supplier;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdatedAt;
}
