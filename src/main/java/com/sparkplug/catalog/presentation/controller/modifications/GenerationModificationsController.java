package com.sparkplug.catalog.presentation.controller.modifications;

import com.sparkplug.catalog.application.dto.modification.ModificationResponseDto;
import com.sparkplug.catalog.application.mapper.ModificationMapper;
import com.sparkplug.catalog.application.service.ModificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sparkplug.catalog.presentation.controller.modifications.GenerationModificationsController.GENERATION_MODIFICATIONS_ENDPOINT;

@RestController
@RequestMapping(GENERATION_MODIFICATIONS_ENDPOINT)
public class GenerationModificationsController {

    public static final String GENERATION_MODIFICATIONS_ENDPOINT = "/generations/{id}/modifications";

    private final ModificationsService service;
    private final ModificationMapper mapper;

    @Autowired
    public GenerationModificationsController(ModificationsService service, ModificationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ModificationResponseDto>> getAll(@PathVariable("id") Long generationId) {

        return ResponseEntity.ok(
                service.getAllByGenerationId(generationId).stream()
                        .map(mapper::toResponseDto)
                        .toList()
        );
    }

}
