package com.jonas.project.garagefix.entity.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewClientData(
        @NotBlank
        String name,
        @NotBlank @Pattern(regexp = "\\d{9}")
        String phoneNumber
) {
}
