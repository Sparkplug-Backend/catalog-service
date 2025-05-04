package com.sparkplug.catalog.application.dto.modification;

public record DetailedModificationDto(

        Long id,
        String name,

        Engine engine,
        Transmission transmission,
        Drivetrain drivetrain,
        Generation generation,
        Model model,
        Manufacturer manufacturer
) {
    public record Engine(
            String fuelType,
            String type,
            Integer horsepower,
            Integer torque
    ) {}

    public record Transmission(
            String type,
            Integer numberOfGears
    ) {}

    public record Drivetrain(
            String type
    ) {}

    public record Generation(
            Long id,
            String name,
            Integer startYear
    ) {}

    public record Model(
            Long id,
            String name
    ) {}

    public record Manufacturer(
            Long id,
            String name,
            String country
    ) {}
}
