package com.project.CostumerSystem.repository;

import com.project.CostumerSystem.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
