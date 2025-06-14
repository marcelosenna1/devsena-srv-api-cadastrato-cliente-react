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
        @NotNull
        @Email(message = "Email inválido")
        String email,
        @NotNull
        @Size(min = 6, max = 30, message = "A senha deve ter entre 6 e 30 caracteres")
        String senha
) {
}
