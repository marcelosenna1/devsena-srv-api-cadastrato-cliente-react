package com.sena.application.adapter.in.dto;

import jakarta.validation.constraints.*;

public record Usuario(
        @Email
        @NotNull(message = "Email deve ser preenchido")
        String email,
        @NotNull(message = "Senha deve ser preenchida")
        @Size(min = 6, max = 30, message = "A senha deve ter entre 6 e 30 caracteres")
        String senha
) {
}
