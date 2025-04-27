package com.sparkplug.catalog.application.dto.generation;

import java.util.List;

public record GenerationResponseDto(
        Long id, String name, Integer startYear, List<Modification> modifications) {

    /**
     * Dto for {@link GenerationResponseDto}
     */
    public record Modification(Long id, String name){}
}
