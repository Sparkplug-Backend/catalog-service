package com.sparkplug.catalog.service;

import com.sparkplug.catalog.application.service.DetailedModificationsService;
import com.sparkplug.common.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Import(DetailedModificationsService.class)
public class DetailedModificationServiceTests extends ServiceTest {

    @Autowired
    DetailedModificationsService service;

    Long modificationId;

    @BeforeEach
    void insertModificationBeforeEach() {
        var manufacturerId = insertManufacturer();
        var carModelId = insertCarModel(manufacturerId);
        var generationId = insertGeneration(carModelId);
        modificationId = insertModification(generationId);
    }

    @Test
    void getDetailedById_whenExists_shouldNotThrow() {
        var result = service.getDetailedById(modificationId);

        assertNotNull(result);
    }

    @Test
    void getDetailedById_whenDoesNotExist_shouldThrow() {
        var id = 8L;

        assertThrows(ResourceNotFoundException.class, () -> service.getDetailedById(id));
    }

    @Test
    void getDetailedInIds_whenExists_notEmpty() {
        var result = service.getDetailedInIds(Set.of(modificationId));

        assertEquals(1, result.size());
    }
}
