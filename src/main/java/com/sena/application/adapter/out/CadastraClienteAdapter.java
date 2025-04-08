package com.sena.application.adapter.out;

import com.sena.application.adapter.out.repository.ClienteRepository;
import com.sena.application.adapter.out.repository.entity.ClienteEntity;
import com.sena.application.adapter.out.repository.mapper.ClienteEntityMapper;
import com.sena.application.core.domain.Cliente;
import com.sena.application.core.port.out.CadastraClienteOutputPort;
import org.springframework.stereotype.Component;

@Component
public class CadastraClienteAdapter implements CadastraClienteOutputPort {

    private final ClienteRepository repository;
    private final ClienteEntityMapper mapper;

    public CadastraClienteAdapter(ClienteRepository repository,
                                  ClienteEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = mapper.INSTANCE.toEntity(cliente);
        var clienteCadastrado = repository.save(clienteEntity);
        return mapper.INSTANCE.toDomain(clienteCadastrado);
    }
}
