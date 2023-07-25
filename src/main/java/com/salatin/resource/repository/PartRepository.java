package com.salatin.resource.repository;

import com.salatin.resource.model.Part;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PartRepository extends ReactiveElasticsearchRepository<Part, String> {

    Mono<Part> findByNumber(String number);
}
