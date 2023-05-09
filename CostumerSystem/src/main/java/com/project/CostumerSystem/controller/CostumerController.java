package com.project.CostumerSystem.controller;

import com.project.CostumerSystem.model.Costumer;
import com.project.CostumerSystem.repository.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("costumer")
@AllArgsConstructor
public class CostumerController {

    private final CostumerRepository costumerRepository;

    @GetMapping
    public List<Costumer> getCostumers() {
        return costumerRepository.findAll();
    }

}
