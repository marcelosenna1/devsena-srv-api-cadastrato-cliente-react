package com.sena.application.core.port.in;

import com.sena.application.core.domain.Cliente;

import java.util.List;

public interface ClienteInputPort {

    Cliente cadastrarCliente(Cliente cliente);
    void deletarCliente(Long id);
    List<Cliente> listarClientes();
    Cliente atualizarCliente(Cliente cliente);
    Cliente buscarClientePorId(Long id);
}
