package com.sena.application.core.port.in;

import com.sena.application.core.domain.Cliente;

import java.util.List;

public interface BuscaClientesInputPort {
    List<Cliente> buscaClientes();
}
