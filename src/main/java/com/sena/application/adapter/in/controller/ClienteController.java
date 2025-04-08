package com.sena.application.adapter.in.controller;

import com.sena.application.adapter.in.controller.dto.ClienteDTO;
import com.sena.application.adapter.in.controller.mapper.ClienteDTOMapper;
import com.sena.application.core.port.in.ClienteInputPort;
import jakarta.validation.Valid;
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
    public ResponseEntity<ClienteDTO> cadastrarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        var cliente = mapper.toDomain(clienteDTO);
        var clienteCadastrado = service.cadastrarCliente(cliente);
        var clienteCadastradoDTO = mapper.toDto(clienteCadastrado);
        return ResponseEntity.ok(clienteCadastradoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        var clientes = service.listarClientes();
        var clienteDTO = mapper.toDtoList(clientes);
        return ResponseEntity.ok(clienteDTO);
    }
}
