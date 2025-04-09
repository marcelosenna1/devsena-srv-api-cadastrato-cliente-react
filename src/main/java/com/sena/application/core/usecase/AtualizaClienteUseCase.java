package com.sena.application.core.usecase;

import com.sena.application.core.domain.Cliente;
import com.sena.application.core.port.in.AtualizaClienteInputPort;
import com.sena.application.core.port.out.AtualizaClienteOutputPort;

public class AtualizaClienteUseCase implements AtualizaClienteInputPort {

    private final AtualizaClienteOutputPort atualizaClienteOutputPort;

    public AtualizaClienteUseCase(AtualizaClienteOutputPort atualizaClienteOutputPort) {
        this.atualizaClienteOutputPort = atualizaClienteOutputPort;
    }

    @Override
    public Cliente atualizaCliente(Cliente cliente) {
        return atualizaClienteOutputPort.atualizaCliente(cliente);
    }
}
