package com.sena.application.core.model;

public record Cliente(
        Long id,
        String nome,
        Integer idade,
        String email
) {
}
