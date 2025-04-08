package com.sena.application.adapter.out;

import com.sena.application.adapter.out.repository.ClienteRepository;
import com.sena.application.adapter.out.repository.mapper.ClienteEntityMapper;
import com.sena.application.core.domain.Cliente;
import com.sena.application.core.exception.ClienteNaoEncontradoException;
import com.sena.application.core.port.in.BuscaClientesInputPort;
import com.sena.application.core.port.out.BuscaClientesOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;

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
        var saida = clienteRepository.findAll();
        return mapper.INSTANCE.toDomainList(saida);
    }
}
