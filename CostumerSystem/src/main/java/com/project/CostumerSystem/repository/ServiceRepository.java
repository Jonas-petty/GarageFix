package com.project.CostumerSystem.repository;

import com.project.CostumerSystem.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
