package com.jonas.project.garagefix.entity.repair;

import com.jonas.project.garagefix.entity.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
public class Repair {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    @Enumerated(EnumType.STRING)
    private ProductKind productKind;
    private String problemDescription;
    private BigDecimal price;

    private boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;

//    public Repair(NewRepairData newRepairData) {
//        this.isActive = true;
//        this.clientId = newRepairData.clientId();
//        this.productKind = newRepairData.productKind();
//        this.problemDescription = newRepairData.problemDescription();
//        this.price = newRepairData.price();
//    }
}