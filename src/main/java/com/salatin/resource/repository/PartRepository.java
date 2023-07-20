package com.salatin.resource.repository;

import com.salatin.resource.model.Part;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends ElasticsearchRepository<Part, Long> {
}
