package com.jonas.project.garagefix.repository;

import com.jonas.project.garagefix.entity.repair.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepairRepository extends JpaRepository<Repair, UUID> {
}
