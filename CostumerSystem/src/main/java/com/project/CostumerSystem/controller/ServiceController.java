package com.project.CostumerSystem.controller;

import com.project.CostumerSystem.DTO.ServiceRequestDTO;
import com.project.CostumerSystem.DTO.ServiceResponseDTO;
import com.project.CostumerSystem.entity.Service;
import com.project.CostumerSystem.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
@AllArgsConstructor
public class ServiceController {

    private final ServiceRepository serviceRepository;

    @GetMapping
    public List<ServiceResponseDTO> getServices() {
        return serviceRepository.findAll().stream().map(ServiceResponseDTO::new).toList();
    }

    @PostMapping
    public void postService(@RequestBody ServiceRequestDTO data) {
        serviceRepository.save(new Service(data));
    }
}
