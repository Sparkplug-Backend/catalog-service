package com.sparkplug.catalog.application.mapper;

import com.sparkplug.catalog.application.dto.modification.ModificationResponseDto;
import com.sparkplug.catalog.domain.model.Modification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModificationMapper {

    @Mapping(target = "generationId", source = "generation.id")
    ModificationResponseDto toResponseDto(Modification m);
}
