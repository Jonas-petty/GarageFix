package com.jonas.project.garagefix.entity.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewProductData(
        @NotBlank
        String problemDescription,

        @NotNull
        ProductKind productKind
) {
}
