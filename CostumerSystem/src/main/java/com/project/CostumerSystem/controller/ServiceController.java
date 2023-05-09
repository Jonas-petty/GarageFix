package com.project.CostumerSystem.controller;

import com.project.CostumerSystem.DTO.ServiceDTO;
import com.project.CostumerSystem.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("service")
@AllArgsConstructor
public class ServiceController {

    private final ServiceRepository serviceRepository;

    @GetMapping
    public List<ServiceDTO> getServices() {
        return serviceRepository.findAll().stream().map(ServiceDTO::new).toList();
    }
}
