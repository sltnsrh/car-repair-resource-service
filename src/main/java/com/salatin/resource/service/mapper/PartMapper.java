package com.salatin.resource.service.mapper;

import com.salatin.resource.model.Part;
import com.salatin.resource.model.dto.request.PartCreationRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PartMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastUpdatedAt", ignore = true)
    Part toModel(PartCreationRequestDto dto);

}
