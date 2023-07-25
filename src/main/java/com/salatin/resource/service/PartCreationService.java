package com.salatin.resource.service;

import com.salatin.resource.model.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PartCreationService {
    private final PartService partService;

    public Mono<Part> create(Part part) {
        var partNumber = part.getNumber();

        return partService.findByNumber(partNumber)
                .hasElement()
                .flatMap(existingPart -> {
                    if (existingPart) {
                        return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT,
                                "The part with number " + partNumber + " is already exist"));
                    } else {
                        return partService.save(part);
                    }
                });
    }

}
