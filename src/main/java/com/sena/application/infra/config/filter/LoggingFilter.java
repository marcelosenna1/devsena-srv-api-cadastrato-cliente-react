package com.sena.application.infra.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();

        try {
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } finally {
            long duration = System.currentTimeMillis() - startTime;

            String method = request.getMethod();
            String uri = request.getRequestURI();
            String query = request.getQueryString();
            int status = response.getStatus();

            String requestBody = getContentAsString(wrappedRequest.getContentAsByteArray());
            String responseBody = getContentAsString(wrappedResponse.getContentAsByteArray());

            logger.info("📥 Requisição: [{} {}{}]", method, uri, query != null ? "?" + query : "");
            logger.info("📝 Body Request: {}", requestBody);
            logger.info("📤 Resposta: [{}] | Tempo: {} ms", status, duration);
            logger.info("📦 Body Response: {}", responseBody);

            wrappedResponse.copyBodyToResponse(); // importante! devolve a resposta pro fluxo normal
        }
    }

    private String getContentAsString(byte[] content) {
        if (content == null || content.length == 0) return "[vazio]";
        return new String(content, StandardCharsets.UTF_8);
    }
}

