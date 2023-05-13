package com.project.CostumerSystem.repository;

import com.project.CostumerSystem.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}
