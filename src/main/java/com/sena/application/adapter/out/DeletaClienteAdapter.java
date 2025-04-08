package com.sena.application.adapter.out;

import com.sena.application.adapter.out.repository.ClienteRepository;
import com.sena.application.core.exception.ClienteNaoEncontradoException;
import com.sena.application.core.port.out.DeletaClienteOutPort;
import org.springframework.stereotype.Component;

@Component
public class DeletaClienteAdapter implements DeletaClienteOutPort {

    private final ClienteRepository repository;

    public DeletaClienteAdapter(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteCliente(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));
        repository.deleteById(id);
    }
}
