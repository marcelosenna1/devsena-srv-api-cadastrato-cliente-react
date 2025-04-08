package com.sena.application.adapter.out.repository.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "cliente")
public record ClienteEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String nome,
        Integer idade,
        String email
) {
}
