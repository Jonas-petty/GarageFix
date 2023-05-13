package com.project.CostumerSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Costumer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

}
