package com.project.CostumerSystem.model;

import com.project.CostumerSystem.DTO.ServiceRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Service {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    public Service(ServiceRequestDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
    }
}
