package com.salatin.resource.controller;

import com.salatin.resource.model.Part;
import com.salatin.resource.model.dto.request.PartCreationRequestDto;
import com.salatin.resource.model.dto.response.PartResponseDto;
import com.salatin.resource.service.PartCreationService;
import com.salatin.resource.service.PartService;
import com.salatin.resource.service.mapper.PartMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class PartCreationController {
    private final PartCreationService creationService;
    private final PartService partService;
    private final PartMapper partMapper;

    @PostMapping
    public Mono<PartResponseDto> create(@RequestBody @Valid PartCreationRequestDto requestDto) {

        return creationService.create(partMapper.toModel(requestDto))
                .doOnNext(part -> log.info("Created a new part: " + part))
                .map(partMapper::toDto);
    }

    @GetMapping("/by-number/{number}")
    public Mono<Part> findByNumber(@PathVariable String number) {
        return partService.findByNumber(number);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Mono<Part> findById(@PathVariable(name = "id") String id) {

        return partService.findById(id);
    }
}
