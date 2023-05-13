package com.project.CostumerSystem.service;

import com.project.CostumerSystem.DTO.CostumerResponseDTO;
import com.project.CostumerSystem.entity.Costumer;
import com.project.CostumerSystem.repository.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CostumerService {

    private final CostumerRepository costumerRepository;

    @Transactional(readOnly = true)
    public List<CostumerResponseDTO> findAll() {
        return costumerRepository.findAll().stream().map(CostumerResponseDTO::new).toList();
    }
}
