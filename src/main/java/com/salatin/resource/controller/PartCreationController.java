package com.salatin.resource.controller;

import com.salatin.resource.model.Part;
import com.salatin.resource.model.dto.request.PartCreationDto;
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
    public Mono<Part> create(@RequestBody PartCreationDto request) {
        var part = new Part();
        part.setName(request.getName());
        part.setBrand(request.getBrand());
        part.setPrice(request.getPrice());
        part.setQuantity(request.getQuantity());
        part.setOemNumber(request.getOemNumber());
        part.setSupplier(request.getSupplier());

        return partService.save(part);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Mono<Part> findById(@PathVariable(name = "id") String id) {

        return partService.findById(id);
    }
}
