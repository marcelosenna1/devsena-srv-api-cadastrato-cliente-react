package com.sena.application.core.port.in;

import com.sena.application.core.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface BuscaClientesInputPort {
    List<Cliente> buscaClientes();
    Optional<Cliente> buscaClientePorId(Long id);
}
