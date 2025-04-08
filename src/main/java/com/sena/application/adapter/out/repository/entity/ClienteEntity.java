package com.sena.application.adapter.out.repository.entity;

import jakarta.persistence.Table;

@Table(name = "cliente")
public record ClienteEntity (
        Long id,
        String nome,
        Integer idade,
        String email
) {
}
