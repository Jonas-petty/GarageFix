package com.jonas.project.garagefix.entity.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String phoneNumber;

    private Boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Client(NewClientData newClient) {
        this.isActive = true;
        this.name = newClient.name();
        this.phoneNumber = newClient.phoneNumber();
    }
}
