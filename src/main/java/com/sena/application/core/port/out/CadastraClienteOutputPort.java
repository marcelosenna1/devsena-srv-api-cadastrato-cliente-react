package com.sena.application.core.port.out;

import com.sena.application.core.domain.Cliente;

public interface CadastraClienteOutputPort {

    public Cliente cadastrarCliente(Cliente cliente);
}
