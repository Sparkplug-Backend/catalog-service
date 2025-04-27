package com.sparkplug.catalog.application.mapper;

import com.sparkplug.catalog.application.dto.carModel.CarModelResponseDto;
import com.sparkplug.catalog.domain.model.CarModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarModelMapper {

    CarModelResponseDto toResponseDto(CarModel c);
}
