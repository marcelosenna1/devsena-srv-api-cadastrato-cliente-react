package com.sena.application.adapter.in.exception.model;


public record ErrorResponse(String message, int status, long timestamp) {
}

