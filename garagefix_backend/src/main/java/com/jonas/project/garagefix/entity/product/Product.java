package com.jonas.project.garagefix.entity.product;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ProductKind productKind;

    private String problemDescription;

    private Boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Product(NewProductData newProduct) {
        this.isActive = true;
        this.productKind = newProduct.productKind();
        this.problemDescription = newProduct.problemDescription();
    }
}
