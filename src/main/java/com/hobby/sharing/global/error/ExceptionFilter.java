package com.hobby.sharing.global.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hobby.sharing.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BusinessException e) {

            String jsonErrorResponse = objectMapper.writeValueAsString(e.getErrorResponse());

            response.setStatus(e.getErrorResponse().getStatus());
            response.setContentType("application/json");
            response.getWriter().write(jsonErrorResponse);
        }
    }
}
