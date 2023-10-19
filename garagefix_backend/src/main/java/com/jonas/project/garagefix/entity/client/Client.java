package com.jonas.project.garagefix.entity.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
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

    public void updateData(ClientUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }

        if (data.phoneNumber() != null) {
            this.phoneNumber = data.phoneNumber();
        }
    }
}
