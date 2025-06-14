package com.sena.application.adapter.out.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    @Column(unique = true)
    private String email;
    private String senha;

    @PrePersist
    void criptografarSenha() {
        this.senha = BCrypt.hashpw(this.senha, BCrypt.gensalt());
    }
}