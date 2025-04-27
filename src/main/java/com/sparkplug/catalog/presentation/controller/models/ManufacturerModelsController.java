package com.sparkplug.catalog.presentation.controller.models;

import com.sparkplug.catalog.application.dto.carModel.CarModelResponseDto;
import com.sparkplug.catalog.application.mapper.CarModelMapper;
import com.sparkplug.catalog.application.service.CarModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sparkplug.catalog.presentation.controller.models.ManufacturerModelsController.MANUFACTURER_MODELS_ENDPOINT;

@RestController
@RequestMapping(MANUFACTURER_MODELS_ENDPOINT)
public class ManufacturerModelsController {

    public static final String MANUFACTURER_MODELS_ENDPOINT = "/manufacturers/{id}/models";

    private final CarModelsService service;
    private final CarModelMapper mapper;

    @Autowired
    public ManufacturerModelsController(CarModelsService service, CarModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CarModelResponseDto>> getAll(@PathVariable("id") Long manufacturerId) {
        return ResponseEntity.ok(
                service.getAllByManufacturerId(manufacturerId).stream()
                        .map(mapper::toResponseDto)
                        .toList()
        );
    }
}
