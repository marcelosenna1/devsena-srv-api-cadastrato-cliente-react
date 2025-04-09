package com.sena.application.adapter.in.controller;

import com.sena.application.adapter.in.controller.dto.request.ClienteRequest;
import com.sena.application.adapter.in.controller.dto.response.ClienteResponse;
import com.sena.application.adapter.in.controller.mapper.ClienteDTOMapper;
import com.sena.application.core.exception.ClienteNaoEncontradoException;
import com.sena.application.core.port.in.ClienteInputPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final ClienteInputPort service;
    private final ClienteDTOMapper mapper;

    public ClienteController(ClienteInputPort service,
                             ClienteDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        var cliente = mapper.toDomain(clienteRequest);
        var clienteCadastrado = service.cadastrarCliente(cliente);
        var clienteResponse = mapper.toResponse(clienteCadastrado);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        service.deletarCliente(id);
        return ResponseEntity
                .noContent()
                .build();
    }
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarClientes() {
        var clientes = service.listarClientes();
        var clienteDTO = mapper.toResponseList(clientes);
        return ResponseEntity.ok(clienteDTO);
    }
    @PutMapping
    public ResponseEntity<ClienteResponse> atualizarCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        var cliente = mapper.toDomain(clienteRequest);
        var clienteAtualizado = service.atualizarCliente(cliente);
        var clienteResponse = mapper.toResponse(clienteAtualizado);
        return ResponseEntity.ok(clienteResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarClientePorId(@PathVariable Long id) {
        var cliente = service.buscarClientePorId(id);
        var clienteResponse = mapper.toResponse(cliente);
        return ResponseEntity.ok(clienteResponse);
    }
}
