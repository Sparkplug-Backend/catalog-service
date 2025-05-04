package com.sparkplug.catalog.presentation.controller.modifications;

import com.sparkplug.catalog.application.dto.modification.DetailedModificationDto;
import com.sparkplug.catalog.application.service.DetailedModificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/modifications/detailed/")
public class DetailedModificationsController {

    private final DetailedModificationsService service;

    @Autowired
    public DetailedModificationsController(DetailedModificationsService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedModificationDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            service.getDetailedById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<DetailedModificationDto>> getInIds(@RequestParam Set<Long> ids) {
        return ResponseEntity.ok(
            service.getDetailedInIds(ids)
        );
    }
}
