package com.sena.application.adapter.out.repository.entity;

import jakarta.persistence.*;

@Entity
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
