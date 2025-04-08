package com.sena.application.core.domain;

public record Cliente(
        Long id,
        String nome,
        Integer idade,
        String email
) {
}
