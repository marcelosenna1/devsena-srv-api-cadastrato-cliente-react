package com.sena.application.adapter.out;

import com.sena.application.adapter.out.repository.ClienteRepository;
import com.sena.application.adapter.out.repository.mapper.ClienteEntityMapper;
import com.sena.application.core.domain.Cliente;
import com.sena.application.core.port.out.BuscaClientesOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BuscaClienteAdapter implements BuscaClientesOutputPort {

    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper mapper;

    public BuscaClienteAdapter(ClienteRepository clienteRepository,
                               ClienteEntityMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Cliente> buscaClientes() {
        return clienteRepository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Cliente> buscaClientePorId(Long id) {
        return clienteRepository.findById(id)
                .map(mapper::toDomain);
    }
}
