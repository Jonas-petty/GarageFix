package com.jonas.project.garagefix.controller;

import com.jonas.project.garagefix.entity.client.ClientDetailsData;
import com.jonas.project.garagefix.entity.repair.*;

import com.jonas.project.garagefix.repository.RepairRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairRepository repository;

    @Autowired
    private RepairManager repairManager;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewRepairData newRepair, UriComponentsBuilder uriBuilder) {
       var createdRepairDetails = repairManager.create(newRepair);
        repository.flush();

        var uri = uriBuilder.path("/repair/{id}").buildAndExpand(createdRepairDetails.id()).toUri();

        return ResponseEntity.created(uri).body(createdRepairDetails);
    }

    @GetMapping
    public ResponseEntity<Page<RepairDetailsData>> list(Pageable pageable) {
        var page = repository.findAllByIsActiveTrue(pageable).map(RepairDetailsData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity searchClient(@PathVariable UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.ok().build();
        } else {
            var repair = repository.getReferenceById(id);
            return ResponseEntity.ok(new RepairDetailsData(repair));
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateRepairData data) {
        var updatedRepairDetails = repairManager.update(data);
        repository.flush();

        return ResponseEntity.ok(updatedRepairDetails);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        var repair = repository.getReferenceById(id);

        repair.delete();

        return ResponseEntity.ok().body("Repair " + repair.getId() + " successfully deleted");
    }


}
