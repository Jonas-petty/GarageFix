package com.project.CostumerSystem.DTO;

import com.project.CostumerSystem.entity.Costumer;
import com.project.CostumerSystem.entity.Service;

public record CostumerResponseDTO(Long id, String name, String phoneNumber, Service service) {

    public CostumerResponseDTO(Costumer costumer) {
        this(costumer.getId(), costumer.getName(), costumer.getPhoneNumber(), costumer.getService());
    }
}
