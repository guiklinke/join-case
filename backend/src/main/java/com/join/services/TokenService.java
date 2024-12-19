package com.join.services;

import com.join.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.jwt.issuer}")
    private String issuer;

    @Value("${api.jwt.secret}")
    private String secretKey;

    @Value("${api.jwt.access-token-expiration}")
    private Long accessKeyExpirationMs;

    public String generateAccessToken(Usuario usuario) {
        return buildAccessToken(usuario, accessKeyExpirationMs);
    }

    public String extractUserIdentifier(String token) {
        return extractAllTokenClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, Usuario usuario) {
        String extractedIdentifier = extractUserIdentifier(token);
        return (extractedIdentifier.equals(usuario.getLogin()) && !isTokenExpired(token));
    }

    private String buildAccessToken(Usuario usuario, long expirationMs) {
        return Jwts
                .builder()
                .subject(usuario.getLogin())
                .issuer(issuer)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + expirationMs))
                .signWith(getSingInKey())
                .compact();
    }

    private Claims extractAllTokenClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSingInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Date extractTokenExpiration(String token) {
        return extractAllTokenClaims(token).getExpiration();
    }

    private boolean isTokenExpired(String token) {
        return extractTokenExpiration(token).before(new Date());
    }

    private SecretKey getSingInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }

}