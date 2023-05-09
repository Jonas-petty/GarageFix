package com.project.CostumerSystem.DTO;

import com.project.CostumerSystem.model.Service;

import java.math.BigDecimal;

public record ServiceResponseDTO(Long id, String name, String description, BigDecimal price) {

    public ServiceResponseDTO(Service service) {
        this(service.getId(), service.getName(), service.getDescription(), service.getPrice());
    }
}
