package com.sena.application.core.port.in;

import com.sena.application.core.domain.Cliente;

public interface CadastraClienteInputPort {

    public Cliente cadastrarCliente(Cliente cliente);
}
