package com.salatin.resource.model;

import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "works")
@Data
public class Work {
    @Id
    private Long id;
    private String name;
    private BigDecimal pricePerHour;
    private String description;
}
