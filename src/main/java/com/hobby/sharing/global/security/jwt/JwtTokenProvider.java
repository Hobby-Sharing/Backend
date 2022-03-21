package com.hobby.sharing.global.security.jwt;

import com.hobby.sharing.global.security.auth.AuthDetailsService;
import com.hobby.sharing.global.security.exception.ExpiredTokenException;
import com.hobby.sharing.global.security.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public String generateAccessToken(String email) {
        return generateToken(email, "access", jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String email) {
        return generateToken(email, "refresh", jwtProperties.getRefreshExp());
    }

    private String generateToken(String email, String type, Long exp) {
        Key key = Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setSubject(email)
                .claim("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .compact();
    }

    public Optional<String> resolveToken(HttpServletRequest request) {
        String BearerToken = request.getHeader(jwtProperties.getHeader());
        return parseToken(BearerToken);
    }

    private Optional<String> parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())) {
            return Optional.of(bearerToken.substring(7));
        }
        return Optional.empty();
    }

    public Claims getTokenBody(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .build()
                        .parseClaimsJws(token).getBody();
        } catch (ExpiredTokenException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public Authentication getAuthentication(Claims tokenBody) {
        if (!checkAccessToken(tokenBody)) {
            throw InvalidTokenException.EXCEPTION;
        }
        UserDetails userDetails = authDetailsService.loadUserByUsername(getEmail(tokenBody));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private boolean checkAccessToken(Claims tokenBody) {
        return tokenBody.get("type", String.class).equals("access");
    }

    private String getEmail(Claims tokenBody) {
        return tokenBody.getSubject();
    }
}
