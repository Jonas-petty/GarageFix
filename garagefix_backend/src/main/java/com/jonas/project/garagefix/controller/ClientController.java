package com.jonas.project.garagefix.controller;


import com.jonas.project.garagefix.entity.client.Client;
import com.jonas.project.garagefix.entity.client.ClientDetailsData;
import com.jonas.project.garagefix.entity.client.NewClientData;
import com.jonas.project.garagefix.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid NewClientData newClient, UriComponentsBuilder uriBuilder) {
        var client = new Client(newClient);

        repository.save(client);

        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClientDetailsData(client));
    }
}