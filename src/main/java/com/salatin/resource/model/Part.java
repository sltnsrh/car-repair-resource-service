package com.salatin.resource.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "parts")
@Data
public class Part {
    private Long id;
    private String name;
    private String brand;
    private Integer oemNumber;
    private BigDecimal price;
    private Integer quantity;
    private String supplier;
    private LocalDateTime receivedAt;
}
