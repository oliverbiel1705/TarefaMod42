package com.gabdev.msClient.controller;

import com.gabdev.msClient.domain.Client;
import com.gabdev.msClient.exception.EntityNotFoundException;
import com.gabdev.msClient.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public record ClientController(ClientService service) {
    @Operation(summary = "Retorna lista de clientes")
    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Operation(summary = "Retorna cliente por id")
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Operation(summary = "Cria novo cliente")
    @PostMapping
    public ResponseEntity<Client> save(@RequestBody @Valid Client client) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(client));
    }

    @Operation(summary = "Deleta cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Atualiza cliente")
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@Valid Client client) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(client));
    }
}
