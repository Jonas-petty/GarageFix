package com.jonas.project.garagefix.controller;

import com.jonas.project.garagefix.entity.repair.NewRepairData;

import com.jonas.project.garagefix.entity.repair.Repair;
import com.jonas.project.garagefix.entity.repair.RepairCreator;
import com.jonas.project.garagefix.entity.repair.RepairDetailsData;
import com.jonas.project.garagefix.repository.RepairRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairRepository repository;

    @Autowired
    private RepairCreator creator;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewRepairData newRepair, UriComponentsBuilder uriBuilder) {
       var cratedRepairDetails = creator.create(newRepair);
        repository.flush();

        var uri = uriBuilder.path("/repair/{id}").buildAndExpand(cratedRepairDetails.id()).toUri();

        return ResponseEntity.created(uri).body(cratedRepairDetails);
    }


}
