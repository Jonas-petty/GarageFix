package com.jonas.project.garagefix.controller;


import com.jonas.project.garagefix.entity.client.Client;
import com.jonas.project.garagefix.entity.client.ClientDetailsData;
import com.jonas.project.garagefix.entity.client.ClientUpdateData;
import com.jonas.project.garagefix.entity.client.NewClientData;
import com.jonas.project.garagefix.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewClientData newClient, UriComponentsBuilder uriBuilder) {
        var client = new Client(newClient);

        repository.save(client);
        repository.flush();

        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClientDetailsData(client));
    }

    @GetMapping
    public ResponseEntity<Page<ClientDetailsData>> list(Pageable pageable) {
        var page = repository.findAllByIsActiveTrue(pageable).map(ClientDetailsData::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ClientUpdateData data) {
        var client = repository.getReferenceById(data.id());
        client.updateData(data);

        return ResponseEntity.ok(new ClientDetailsData(client));
    }
}
