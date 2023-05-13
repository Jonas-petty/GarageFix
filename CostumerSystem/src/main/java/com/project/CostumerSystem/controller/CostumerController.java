package com.project.CostumerSystem.controller;

import com.project.CostumerSystem.DTO.CostumerResponseDTO;
import com.project.CostumerSystem.entity.Costumer;
import com.project.CostumerSystem.repository.CostumerRepository;
import com.project.CostumerSystem.service.CostumerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("costumer")
@AllArgsConstructor
public class CostumerController {

    private final CostumerService costumerService;

    @GetMapping
    public List<CostumerResponseDTO> getCostumers() {
        return costumerService.findAll();
    }

}
