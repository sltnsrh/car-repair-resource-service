package com.salatin.resource.service.impl;

import com.salatin.resource.model.Work;
import com.salatin.resource.repository.WorkRepository;
import com.salatin.resource.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {
    private final WorkRepository workRepository;

    @Override
    public Mono<Work> findById(Long id) {
        return workRepository.findById(id);
    }

    @Override
    public Mono<Work> save(Work work) {
        return workRepository.save(work);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return workRepository.deleteById(id);
    }
}
