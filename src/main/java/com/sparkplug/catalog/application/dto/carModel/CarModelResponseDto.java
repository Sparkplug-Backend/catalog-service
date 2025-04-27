package com.sparkplug.catalog.application.dto.carModel;

import com.sparkplug.catalog.domain.model.Generation;
import com.sparkplug.catalog.domain.model.Manufacturer;

import java.util.List;

public record CarModelResponseDto(
        Long id, String name, ManufacturerDto manufacturer, List<GenerationDto> generations) {

    /**
     * DTO for {@link Manufacturer}
     */
    public record ManufacturerDto(Long id, String name) {
    }

    /**
     * DTO for {@link Generation}
    */
    public record GenerationDto(Long id, String name) {
    }
}
