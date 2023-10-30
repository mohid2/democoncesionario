package com.projectoconcesionario.concesionario.domain.service.impl;

import com.projectoconcesionario.concesionario.domain.service.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;
@Service
public class JwtServiceImpl implements IJwtService {

    private static final String SECRET_KEY = "64d5113480588d2c99cfb9f74c5cfd12e23ce08c705d9da1b870a9409f79f340";
    private static final Long EXPIRATION_DATE  = 9045000L;
    private final HashMap<String, UserDetails> listToken = new HashMap<>();


    public String generateToken( UserDetails userDetails,Map<String,Object> extraClaims){

        String tokenCreated = Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_DATE))
                .setHeaderParam(Header.TYPE,Header.JWT_TYPE)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        listToken.put(tokenCreated,userDetails);
        return tokenCreated;
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String getUserEmailForToken(String token) {
        return getClaim(token,Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUserEmailForToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }



    @Override
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
        
    }

    @Override
    public String deleteToken(String jwt) {
        if (!listToken.containsKey(jwt)) {
            return "No existe token";
        }
        listToken.remove(jwt);
        return "Successfully authenticated.";
    }

    private Claims getAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build().parseClaimsJws(token)
                .getBody();
    }
    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return getClaim(token,Claims::getExpiration);
    }
}
