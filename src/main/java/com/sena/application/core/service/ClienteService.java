package com.sena.application.core.service;

import com.sena.application.core.domain.Cliente;
import com.sena.application.core.port.in.BuscaClientesInputPort;
import com.sena.application.core.port.in.CadastraClienteInputPort;
import com.sena.application.core.port.in.ClienteInputPort;
import com.sena.application.core.port.in.DeletaClienteInputPort;

import java.util.List;

public class ClienteService implements ClienteInputPort {

    private final CadastraClienteInputPort cadastraClienteInputPort;
    private final DeletaClienteInputPort deletaClienteInputPort;
    private final BuscaClientesInputPort buscaClientesInputPort;

    public ClienteService(CadastraClienteInputPort cadastraClienteInputPort,
                          DeletaClienteInputPort deletaClienteInputPort,
                          BuscaClientesInputPort buscaClientesInputPort) {
        this.cadastraClienteInputPort = cadastraClienteInputPort;
        this.deletaClienteInputPort = deletaClienteInputPort;
        this.buscaClientesInputPort = buscaClientesInputPort;
    }


    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        return cadastraClienteInputPort.cadastrarCliente(cliente);
    }

    @Override
    public void deletarCliente(Long id) {
        deletaClienteInputPort.deleteCliente(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return buscaClientesInputPort.buscaClientes();
    }
}
