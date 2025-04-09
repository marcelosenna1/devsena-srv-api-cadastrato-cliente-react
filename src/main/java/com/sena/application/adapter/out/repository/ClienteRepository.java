package com.sena.application.adapter.out.repository;

import com.sena.application.adapter.out.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    Boolean existsByNome(String nome);
    Boolean existsByEmail(String email);
    Optional<ClienteEntity> findByEmail(String email);

}
