package com.sena.application.adapter.in.security;

import com.sena.application.adapter.out.repository.ClienteRepository;
import com.sena.application.adapter.out.repository.entity.ClienteEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final ClienteRepository clienteRepository;

    public UsuarioDetailsService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClienteEntity cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail: " + email));

        return new User(
                cliente.getEmail(),
                cliente.getSenha(),
                Collections.singletonList(() -> "ROLE_USER") // Adiciona uma role padrão
        );
    }
}
