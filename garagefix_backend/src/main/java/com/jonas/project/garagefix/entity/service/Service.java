package com.jonas.project.garagefix.entity.service;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Service {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    private UUID clientID;

    // Delete the product entity and move inside the Service
    private UUID productId;

    private BigDecimal price;

    private boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
