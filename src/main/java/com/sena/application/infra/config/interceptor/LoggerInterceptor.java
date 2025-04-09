package com.sena.application.infra.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor para registrar informações sobre as requisições HTTP nos logs de entrada e saída.
 * Essa classe foi criada baseada em atigos no baeldung.
 * <a href="https://www.baeldung.com/spring-mvc-handlerinterceptor">...</a>
 * <a href="https://www.baeldung.com/spring-mvc-handlerinterceptor-vs-filter">...</a>
 */
@Component
public class LoggerInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    private static final String START_TIME = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME, startTime);

        logger.info("📥 Início da requisição: [{} {}]", request.getMethod(), request.getRequestURI());
        logger.info("🔍 Params: {}", request.getQueryString());

        return true; // segue com a requisição
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Long startTime = (Long) request.getAttribute(START_TIME);
        long duration = System.currentTimeMillis() - startTime;

        logger.info("📤 Fim da requisição: [{} {}] | Status: {} | Tempo: {} ms",
                request.getMethod(), request.getRequestURI(), response.getStatus(), duration);
    }
}
