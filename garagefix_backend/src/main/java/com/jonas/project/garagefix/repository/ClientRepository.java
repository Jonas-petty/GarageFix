package com.jonas.project.garagefix.repository;

import com.jonas.project.garagefix.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
