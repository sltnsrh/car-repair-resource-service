package com.salatin.resource.service;

import com.salatin.resource.model.Part;
import reactor.core.publisher.Mono;

public interface PartService {

    Mono<Part> findById(String id);

    Mono<Part> save(Part part);

    Mono<Part> findByNumber(String number);

    Mono<Void> deleteById(String id);
}
