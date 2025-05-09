package com.sparkplug.catalog.application.service;

import com.sparkplug.catalog.domain.model.CarModel;
import com.sparkplug.catalog.domain.model.Manufacturer;
import com.sparkplug.catalog.domain.repository.CarModelsRepository;
import com.sparkplug.common.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarModelsService {

    private final CarModelsRepository repository;
    private final Sort defaultSort;

    @Autowired
    public CarModelsService(CarModelsRepository repository) {
        this.repository = repository;
        this.defaultSort = Sort.by(Sort.Order.asc("name"));
    }

    @Transactional
    public Long create(String name, Long manufacturerId) {
        var carModel = CarModel.builder()
                .name(name)
                .manufacturer(
                        Manufacturer.builder()
                                .id(manufacturerId)
                                .build())
                .build();

        return repository.save(carModel).getId();
    }

    public List<CarModel> getAll() {
        return repository.findAll(defaultSort);
    }

    public List<CarModel> getAllByManufacturerId(Long manufacturerId) {
        return repository.findAllByManufacturerId(manufacturerId, defaultSort);
    }

    public CarModel getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car model", id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
