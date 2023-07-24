package com.salatin.resource.controller;

import com.salatin.resource.model.Part;
import com.salatin.resource.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parts")
@RequiredArgsConstructor
public class PartCreationController {
    private final PartService partService;

    @PostMapping
    public Mono<Part> create(@RequestBody Part request) {

        return partService.save(request);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Mono<Part> findById(@PathVariable Long id) {

        return partService.findById(id);
    }
}
