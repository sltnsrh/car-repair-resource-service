package com.salatin.resource.service.impl;

import com.salatin.resource.model.Part;
import com.salatin.resource.repository.PartRepository;
import com.salatin.resource.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;

    @Override
    public Mono<Part> findById(Long id) {
        return Mono.just(partRepository.findById(id).get());
    }

    @Override
    public Mono<Part> save(Part part) {
        return Mono.just(partRepository.save(part));
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        partRepository.deleteById(id);

        return Mono.empty();
    }
}
