package com.jonas.project.garagefix.entity.repair;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateRepairData(
        @NotNull
        UUID id,
        UUID clientId,
        ProductKind productKind,
        String problemDescription,
        BigDecimal price

) {

}
