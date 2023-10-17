package com.pub.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtTokenService {
    private static final String secret = "11b9bfb2d5ea462d8a8f73454b2a4c385d592504934d15432c6d5dfb2ddb8db9";
    public String extractName(String jwt) {
        return null;
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts.parserBuilder().
                setSigningKey( getSighInKey()).
                build()
                .parseClaimsJws(jwt)
                .getBody();
    }
    private Key getSighInKey() {
        byte[] secretBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(secretBytes);
    }
}
