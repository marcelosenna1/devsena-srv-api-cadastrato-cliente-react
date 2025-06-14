package com.sena.application.adapter.in.controller;

import com.sena.application.adapter.in.dto.TokenResponse;
import com.sena.application.adapter.in.dto.Usuario;
import com.sena.application.adapter.in.service.AutenticacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/login")
public class LoginController {

    private final AutenticacaoService autenticacaoService;

    public LoginController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        TokenResponse token = autenticacaoService.autenticar(usuario.email(), usuario.senha());
        return ResponseEntity.ok(token);
    }
}
