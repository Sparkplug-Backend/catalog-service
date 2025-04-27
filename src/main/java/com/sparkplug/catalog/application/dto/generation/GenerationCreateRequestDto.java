package com.sparkplug.catalog.application.dto.generation;

public record GenerationCreateRequestDto(Long carModelId, String name, Integer startYear) {
}
