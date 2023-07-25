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
    public Mono<Part> save(Part part) {
        return partRepository.save(part);
    }

    @Override
    public Mono<Part> findById(String id) {
        return partRepository.findById(id);
    }

    @Override
    public Mono<Part> findByNumber(String number) {
        return partRepository.findByNumber(number);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return partRepository.deleteById(id);
    }
}
