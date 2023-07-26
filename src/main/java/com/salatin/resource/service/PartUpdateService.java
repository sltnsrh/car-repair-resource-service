package com.salatin.resource.service;

import com.salatin.resource.model.Part;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Log4j2
public class PartUpdateService {
    private final PartService partService;

    public Mono<Part> update(Part part) {
        var partId = part.getId();
        var partNumber = part.getNumber();

        Mono<Part> findByIdMono = partService.findById(partId)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Can't find a part with id: " + partId)));

        Mono<Part> findByNumberMono = partService.findByNumber(partNumber)
                .flatMap(partWithSameNumber -> {
                    if (!partWithSameNumber.getId().equals(partId)) {
                        log.error("A part with number {} already exists, update failed", partNumber);
                        return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT,
                                "A part with the same number: " + partNumber + " already exists"));
                    }
                    return Mono.just(partWithSameNumber);
                });

        return Mono.zip(findByIdMono, findByNumberMono)
                .flatMap(tuple -> partService.save(part));
    }

}
