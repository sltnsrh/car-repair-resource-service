package com.salatin.resource.repository;

import com.salatin.resource.model.Work;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends ReactiveElasticsearchRepository<Work, String> {
}
