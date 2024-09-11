package com.gabdev.msProduct.controller;

import com.gabdev.msProduct.domain.Product;
import com.gabdev.msProduct.exception.ProductNotFoundException;
import com.gabdev.msProduct.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public record ProductController(ProductService service) {
    @Operation(summary = "Retorna lista de produtos")
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Operation(summary = "Retorna produto por id")
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String code) throws ProductNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(code));
    }

    @Operation(summary = "Cria novo produto")
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(product));
    }

    @Operation(summary = "Deleta produto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        service.delete(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Atualiza produto")
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@Valid Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(product));
    }
}
