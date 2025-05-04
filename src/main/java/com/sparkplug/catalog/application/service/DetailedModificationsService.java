package com.sparkplug.catalog.application.service;

import com.sparkplug.catalog.application.dto.modification.DetailedModificationDto;
import com.sparkplug.catalog.domain.repository.DetailedModificationRepository;
import com.sparkplug.common.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DetailedModificationsService {

    private final DetailedModificationRepository repository;

    @Autowired
    public DetailedModificationsService(DetailedModificationRepository repository) {
        this.repository = repository;
    }

    public DetailedModificationDto getDetailedById(Long id) {
        return repository.findDetailedById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detailed modification", id));
    }

    public List<DetailedModificationDto> getDetailedInIds(Set<Long> ids) {
        return repository.findDetailedInIds(ids);
    }
}
