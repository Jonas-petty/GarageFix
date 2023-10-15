package com.jonas.project.garagefix.entity.client;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientDetailsData(
        UUID id,
        String nome,
        String phoneNumber,
        LocalDateTime createdAt
) {
    public ClientDetailsData(Client client) {
        this(client.getId(), client.getName(), client.getPhoneNumber(), client.getCreatedAt());
    }
}
