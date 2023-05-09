package com.project.CostumerSystem.DTO;

import com.project.CostumerSystem.model.Service;

import java.math.BigDecimal;

public record ServiceDTO(Long id, String name, BigDecimal price) {

    public ServiceDTO(Service service) {
        this(service.getId(), service.getName(), service.getPrice());
    }
}
