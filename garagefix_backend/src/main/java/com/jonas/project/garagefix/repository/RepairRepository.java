package com.jonas.project.garagefix.repository;

import com.jonas.project.garagefix.entity.repair.Repair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepairRepository extends JpaRepository<Repair, UUID> {
    Page<Repair> findAllByIsActiveTrue(Pageable pageable);

    @Query("""
            SELECT r FROM Repair r
            WHERE
            r.isActive = true
            AND
            r.client.id = :id
            """)
    Page<Repair> findAllByClientId(UUID id, Pageable pageable);
}
