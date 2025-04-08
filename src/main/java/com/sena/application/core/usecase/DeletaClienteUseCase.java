package com.sena.application.core.usecase;

import com.sena.application.core.port.in.DeletaClienteInputPort;
import com.sena.application.core.port.out.DeletaClienteOutPort;

public class DeletaClienteUseCase implements DeletaClienteInputPort {

    private final DeletaClienteOutPort deletaClienteOutPort;

    public DeletaClienteUseCase(DeletaClienteOutPort deletaClienteOutPort) {
        this.deletaClienteOutPort = deletaClienteOutPort;
    }

    @Override
    public void deleteCliente(Long id) {
        deletaClienteOutPort.deleteCliente(id);
    }
}
