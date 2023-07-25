package com.salatin.resource.model;

import com.salatin.resource.util.ElasticIndex;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = ElasticIndex.PART)
@Data
public class Part {
    @Id
    private String id;
    private String name;
    private String brand;
    private String number;
    @Field(type = FieldType.Text)
    private Set<String> oemNumbers = new HashSet<>();
    private BigDecimal price;
    private Integer quantity;
    private String supplier;
    @LastModifiedDate
    @Field(type = FieldType.Date)
    private LocalDateTime lastUpdatedAt = LocalDateTime.now();
}
