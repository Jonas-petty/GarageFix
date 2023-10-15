package com.jonas.project.garagefix.controller;

import com.jonas.project.garagefix.entity.product.NewProductData;
import com.jonas.project.garagefix.entity.product.Product;

import com.jonas.project.garagefix.entity.product.ProductDetailsData;
import com.jonas.project.garagefix.repository.ProductRepository;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewProductData newProduct, UriComponentsBuilder uriBuilder) {
        var product = new Product(newProduct);

        repository.save(product);
        repository.flush();

        var uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductDetailsData(product));
    }


}
