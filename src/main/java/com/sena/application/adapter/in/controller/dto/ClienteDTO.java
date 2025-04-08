package com.sena.application.adapter.in.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ClienteDTO(
        Long id,
        @NotNull(message = "Nome deve ser preenchido")
        String nome,
        @NotNull
        @Min(value = 18, message = "Idade deve ser maior ou igual a 18")
        @Max(value = 120, message = "Idade deve ser menor ou igual a 120")
        Integer idade,

        @Email(message = "Email inválido")
        String email
) {
}
