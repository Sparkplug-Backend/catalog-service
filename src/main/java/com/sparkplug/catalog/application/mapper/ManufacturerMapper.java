package com.sparkplug.catalog.application.mapper;

import com.sparkplug.catalog.application.dto.manufacturer.ManufacturerResponseDto;
import com.sparkplug.catalog.domain.model.Manufacturer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {

    ManufacturerResponseDto toResponseDto(Manufacturer m);
}
