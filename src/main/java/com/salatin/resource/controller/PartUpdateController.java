package com.salatin.resource.controller;

import com.salatin.resource.model.dto.request.PartUpdateRequestDto;
import com.salatin.resource.model.dto.response.PartResponseDto;
import com.salatin.resource.service.PartUpdateService;
import com.salatin.resource.service.mapper.PartMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parts")
@RequiredArgsConstructor
@Log4j2
public class PartUpdateController {
    private final PartUpdateService updateService;
    private final PartMapper partMapper;

    @PutMapping
    public Mono<PartResponseDto> update(@RequestBody @Valid PartUpdateRequestDto requestDto) {

        return updateService.update(partMapper.toModel(requestDto))
                .doOnNext(part -> log.info("Updated a part: " + part))
                .map(partMapper::toDto);
    }

}
