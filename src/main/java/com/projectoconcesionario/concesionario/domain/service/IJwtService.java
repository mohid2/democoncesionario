package com.projectoconcesionario.concesionario.domain.service;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
public interface IJwtService {

    String generateToken(UserDetails userDetails, Map<String,Object> extraClaims);
    String getUserEmailForToken(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    <T> T getClaim(String token, Function<Claims,T> claimsResolver);
}
