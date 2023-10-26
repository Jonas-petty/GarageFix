package com.jonas.project.garagefix.entity.repair;

import com.jonas.project.garagefix.entity.client.Client;
import com.jonas.project.garagefix.repository.ClientRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
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

    public void delete() {
        this.isActive = false;
    }
}
