package com.sena.application.core.port.out;

import com.sena.application.core.domain.Cliente;

import java.util.List;

public interface BuscaClientesOutputPort {

    List<Cliente> buscaClientes();
}
