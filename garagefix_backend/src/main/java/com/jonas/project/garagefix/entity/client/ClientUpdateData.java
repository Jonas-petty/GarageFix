package com.jonas.project.garagefix.entity.client;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClientUpdateData (
        @NotNull
        UUID id,
        String name,
        String phoneNumber
) {
}
