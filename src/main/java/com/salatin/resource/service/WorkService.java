package com.salatin.resource.service;

import com.salatin.resource.model.Work;
import reactor.core.publisher.Mono;

public interface WorkService {

    Mono<Work> findById(String id);

    Mono<Work> save(Work work);

    Mono<Void> deleteById(String id);
}
