package com.sena.application.adapter.in.controller;

import com.sena.application.core.domain.Cliente;
import com.sena.application.core.port.in.ClienteInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final ClienteInputPort service;

    public ClienteController(ClienteInputPort service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        var clienteCadastrado = service.cadastrarCliente(cliente);
        return ResponseEntity.ok(clienteCadastrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        var clientes = service.listarClientes();
        return ResponseEntity.ok(clientes);
    }
}
