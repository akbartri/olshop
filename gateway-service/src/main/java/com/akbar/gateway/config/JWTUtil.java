package com.akbar.gateway.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;

//@Component
public class JWTUtil {
//    @Value("${jwt.secret}")
//    private String secret;
//
//    private Key key;
//
//    @PostConstruct
//    public void init() {
//        this.key = Keys.hmacShaKeyFor(secret.getBytes());
//    }
//
//    public Claims getAllClaimsFromToken(String token) {
//        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
//    }
//
//    private boolean isTokenExpired(String token) {
//        return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
//    }
//
//    public boolean isInvalid(String token) {
//        return this.isTokenExpired(token);
//    }

//    public Claims getClaims(String token) {
//        try {
//            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//        } catch (Exception e) {
//            System.out.println(e.getMessage() + " => " + e);
//        }
//        return null;
//    }
//
//    public void validateToken(String token) throws JWTTokenMalformedException, JWTTokenMissingException {
//        try {
//            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//        } catch (SignatureException e) {
//            throw new JWTTokenMalformedException("Invalid JWT Signature");
//        } catch (MalformedJwtException e) {
//            throw new JWTTokenMalformedException("Invalid JWT token");
//        } catch (ExpiredJwtException e) {
//            throw new JWTTokenMalformedException("Expired JWT token");
//        } catch (UnsupportedJwtException e) {
//            throw new JWTTokenMalformedException("Unsupported JWT token");
//        } catch (IllegalArgumentException e) {
//            throw new JWTTokenMissingException("JWT claims string is empty");
//        }
//    }
}
