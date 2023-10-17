package com.jonas.project.garagefix.entity.repair;

import com.jonas.project.garagefix.entity.client.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record RepairDetailsData(
        UUID id,

        UUID clientId,
        ProductKind productKind,
        String problemDescription,
        BigDecimal price,
        LocalDateTime createdAt

) {
    public RepairDetailsData(Repair repair) {
        this(repair.getId(), repair.getClient().getId(), repair.getProductKind(),
                repair.getProblemDescription(), repair.getPrice(), repair.getCreatedAt());
    }
}
