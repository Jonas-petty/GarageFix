package com.jonas.project.garagefix.entity.product;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDetailsData(
        UUID id,
        ProductKind productKind,
        String problemDescription,
        LocalDateTime createdAt

) {
    public ProductDetailsData(Product product) {
        this(product.getId(), product.getProductKind(), product.getProblemDescription(), product.getCreatedAt());
    }
}
