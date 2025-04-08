package com.sena.application.core.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteNaoEncontradoException(Long id) {
        super("Cliente não encontrado com o ID: " + id);
    }
}
