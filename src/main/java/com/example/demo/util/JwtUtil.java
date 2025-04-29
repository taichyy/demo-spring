package com.example.demo.util;

import com.example.demo.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.security.Key;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    // Fetch the secret key from application properties
    private String secretKey;  

    // Save the key.
    private Key key;  

    @PostConstruct
    public void init() {
        if (secretKey == null || secretKey.isEmpty()) {
            throw new IllegalStateException("Secret key is not properly configured!");
        }
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // Generate JWT token
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUserId().toString())
                .claim("phone", user.getPhone())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    // Extract user ID from JWT token
    public Long extractUserId(String token) {
        return Long.parseLong(Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }

    // Get Bearer Token from HTTP Authorization header 
    public String extractTokenFromHeader(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Remove "Bearer "
            return authorizationHeader.substring(7); 
        } else {
            throw new RuntimeException("Authorization header is missing or invalid");
        }
    }
}