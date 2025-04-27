package com.sparkplug.catalog.application.mapper;

import com.sparkplug.catalog.application.dto.generation.GenerationResponseDto;
import com.sparkplug.catalog.domain.model.Generation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenerationMapper {

    GenerationResponseDto toResponseDto(Generation g);
}
