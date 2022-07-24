package com.akbar.auth.utility;

import com.akbar.auth.dto.vo.UserVO;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {

//    private static final long serialVersionUID = 234234523523L;

//    @Value("${jwt.secret}")
//    private String secretKey;
//
//    @Value("${jwt.expiration}")
//    private long expirationTime;
//
//    private Key key;
//
//    @PostConstruct
//    public void init() {
//        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
//    }
//
//    public Claims getAllClaimsFromToken(String token) {
//        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
//    }
//
//    public Date getExpirationDateFromToken(String token) {
//        return getAllClaimsFromToken(token).getExpiration();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//    public String generate(UserVO userVO, String type) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id", userVO.getId());
//        claims.put("role", userVO.getRole());
//        return doGenerateToken(claims, userVO.getEmail(), type);
//    }
//
//    private String doGenerateToken(Map<String, Object> claims, String username, String type) {
//        long expirationTimeLong;
//        if ("ACCESS".equals(type)) {
//            expirationTimeLong = expirationTime * 1000;
//        } else {
//            expirationTimeLong = expirationTime * 1000 * 5;
//        }
//        final Date createdDate = new Date();
//        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(username)
//                .setIssuedAt(createdDate)
//                .setExpiration(expirationDate)
//                .signWith(key)
//                .compact();
//    }
//
//    public Boolean validateToken(String token) {
//        return !isTokenExpired(token);
//    }

//    public Claims getClaims(String token) {
//        try {
//            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//        } catch (Exception e) {
//            System.out.println(e.getMessage()+" => "+e);
//        }
//
//        return null;
//    }
//
//    public String generateToken(String id) {
//        Claims claims = Jwts.claims().setSubject(id);
//        long nowMillis = System.currentTimeMillis();
//        long expMillis = nowMillis + expirationTime;
//
//        Date expired = new Date(expMillis);
//
//        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(expired)
//                .signWith(SignatureAlgorithm.HS512, secretKey).compact();
//    }
//
//    public void validateToken(String token) throws JWTTokenMalformedException, JWTTokenMissingException {
//        try {
//            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
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
