package com.sena.application.adapter.out.repository;

import com.sena.application.adapter.out.repository.entity.ClienteEntity;
import com.sena.application.core.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
