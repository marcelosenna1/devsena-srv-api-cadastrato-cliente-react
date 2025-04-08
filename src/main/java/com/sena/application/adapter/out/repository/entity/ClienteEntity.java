package com.sena.application.adapter.out.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public record ClienteEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @NotNull(message = "Nome não deve ser preenchido")
        String nome,

        @NotNull
        @Min(value = 18, message = "Idade deve ser maior ou igual a 18")
        Integer idade,

        @Email(message = "Email inválido")
        String email
) {
}
