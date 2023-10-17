package com.jonas.project.garagefix.entity.repair;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record NewRepairData(

        @NotNull
        UUID clientId,
        @NotBlank
        String problemDescription,
        @NotNull
        ProductKind productKind,

        @NotNull
        BigDecimal price
) {
}
