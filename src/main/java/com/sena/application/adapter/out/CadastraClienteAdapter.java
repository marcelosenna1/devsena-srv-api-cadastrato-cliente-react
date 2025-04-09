package com.sena.application.adapter.out;

import com.sena.application.adapter.out.repository.ClienteRepository;
import com.sena.application.adapter.out.repository.entity.ClienteEntity;
import com.sena.application.adapter.out.repository.mapper.ClienteEntityMapper;
import com.sena.application.core.domain.Cliente;
import com.sena.application.core.exception.ClienteDuplicadoException;
import com.sena.application.core.exception.EmailDuplicadoException;
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
        ClienteEntity clienteEntity = mapper.toEntity(cliente);

        if(repository.existsByNome(cliente.nome()) && repository.existsByEmail(cliente.email())){
            throw new ClienteDuplicadoException("Cliente já cadastrado com o mesmo nome e email");
        }
        if(repository.existsByEmail(cliente.email())){
            throw new EmailDuplicadoException("Este email já se encontra na base de dados. Tente outro.");
        }
        var clienteCadastrado = repository.save(clienteEntity);
        return mapper.toDomain(clienteCadastrado);
    }
}
