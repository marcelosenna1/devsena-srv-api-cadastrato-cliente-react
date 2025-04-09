package com.sena.application.adapter.in.controller.dto.response;

public record ClienteResponse(
        Long id,
        String nome,
        Integer idade,
        String email
) {
}
