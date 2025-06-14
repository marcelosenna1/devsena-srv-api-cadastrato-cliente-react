package com.sena.application.adapter.in.service;

import com.sena.application.adapter.in.dto.TokenResponse;
import com.sena.application.infra.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AutenticacaoService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public TokenResponse autenticar(String email, String senha) {
        var authInput = new UsernamePasswordAuthenticationToken(email, senha);
        var auth = authenticationManager.authenticate(authInput);
        var token = jwtTokenUtil.generateToken(auth);
        return new TokenResponse(token);
    }
}
