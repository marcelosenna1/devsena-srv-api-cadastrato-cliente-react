package com.sena.application.core.service;

import com.sena.application.core.domain.Cliente;
import com.sena.application.core.exception.ClienteNaoEncontradoException;
import com.sena.application.core.port.in.*;

import java.util.List;

public class ClienteService implements ClienteInputPort {

    private final CadastraClienteInputPort cadastraClienteInputPort;
    private final DeletaClienteInputPort deletaClienteInputPort;
    private final BuscaClientesInputPort buscaClientesInputPort;
    private final AtualizaClienteInputPort atualizaClienteInputPort;

    public ClienteService(CadastraClienteInputPort cadastraClienteInputPort,
                          DeletaClienteInputPort deletaClienteInputPort,
                          BuscaClientesInputPort buscaClientesInputPort,
                          AtualizaClienteInputPort atualizaClienteInputPort) {
        this.cadastraClienteInputPort = cadastraClienteInputPort;
        this.deletaClienteInputPort = deletaClienteInputPort;
        this.buscaClientesInputPort = buscaClientesInputPort;
        this.atualizaClienteInputPort = atualizaClienteInputPort;
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
    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return atualizaClienteInputPort.atualizaCliente(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return buscaClientesInputPort.buscaClientePorId(id).orElseThrow(
                () -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));
    }
}
