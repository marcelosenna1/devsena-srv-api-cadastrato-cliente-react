package com.sena.application.core.usecase;

import com.sena.application.core.domain.Cliente;
import com.sena.application.core.port.in.CadastraClienteInputPort;
import com.sena.application.core.port.out.CadastraClienteOutputPort;

public class CadastraClienteUseCase implements CadastraClienteInputPort {

    private final CadastraClienteOutputPort cadastraClienteOutPort;

    public CadastraClienteUseCase(CadastraClienteOutputPort cadastraClienteOutPort) {
        this.cadastraClienteOutPort = cadastraClienteOutPort;
    }
    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        return cadastraClienteOutPort.cadastrarCliente(cliente);
    }
}
