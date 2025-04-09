package com.sena.application.adapter.out;

import com.sena.application.adapter.out.repository.ClienteRepository;
import com.sena.application.adapter.out.repository.mapper.ClienteEntityMapper;
import com.sena.application.core.domain.Cliente;
import com.sena.application.core.exception.ClienteNaoEncontradoException;
import com.sena.application.core.port.out.AtualizaClienteOutputPort;
import com.sena.application.core.port.out.BuscaClientesOutputPort;
import org.springframework.stereotype.Component;

@Component
public class AtualizaClienteAdapter implements AtualizaClienteOutputPort {

    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper mapper;

    public AtualizaClienteAdapter(ClienteRepository clienteRepository, ClienteEntityMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    @Override
    public Cliente atualizaCliente(Cliente cliente) {
        var clienteExistente = clienteRepository.findByEmail(cliente.email())
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente com email " + cliente.email() + " não encontrado."));

        var clienteEntity = mapper.toEntity(cliente);
        clienteEntity.setId(clienteExistente.getId());

        var clienteAtualizado = clienteRepository.save(clienteEntity);
        return mapper.toDomain(clienteAtualizado);
    }
}
