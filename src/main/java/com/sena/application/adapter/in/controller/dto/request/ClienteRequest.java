package com.sena.application.adapter.in.controller.dto.request;

import jakarta.validation.constraints.*;

public record ClienteRequest(
        @NotNull(message = "Nome deve ser preenchido")
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Nome não deve conter números ou caracteres especiais")
        String nome,
        @NotNull
        @Min(value = 18, message = "Idade deve ser maior ou igual a 18")
        @Max(value = 120, message = "Idade deve ser menor ou igual a 120")
        Integer idade,
        @Email(message = "Email inválido")
        String email
) {
}
