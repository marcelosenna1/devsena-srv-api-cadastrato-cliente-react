package com.sena.application.core.usecase;

import com.sena.application.core.domain.Cliente;
import com.sena.application.core.port.in.BuscaClientesInputPort;
import com.sena.application.core.port.out.BuscaClientesOutputPort;

import java.util.List;
import java.util.Optional;

public class BuscaClientesUseCase implements BuscaClientesInputPort {

    private final BuscaClientesOutputPort buscaClientesOutPort;

    public BuscaClientesUseCase(BuscaClientesOutputPort buscaClientesOutPort) {
        this.buscaClientesOutPort = buscaClientesOutPort;
    }

    @Override
    public List<Cliente> buscaClientes() {
        return buscaClientesOutPort.buscaClientes();
    }

    @Override
    public Optional<Cliente> buscaClientePorId(Long id) {
        return buscaClientesOutPort.buscaClientePorId(id);
    }
}
