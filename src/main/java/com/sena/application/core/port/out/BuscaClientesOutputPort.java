package com.sena.application.core.port.out;

import com.sena.application.core.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface BuscaClientesOutputPort {

    List<Cliente> buscaClientes();
    Optional<Cliente> buscaClientePorId(Long id);
}
