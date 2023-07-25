package com.salatin.resource.model;

import com.salatin.resource.util.ElasticIndex;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = ElasticIndex.WORK)
@Data
public class Work {
    @Id
    private Long id;
    private String name;
    private BigDecimal pricePerHour;
    private String description;
}
