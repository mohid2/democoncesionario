package com.projectoconcesionario.concesionario.controller;

import com.projectoconcesionario.concesionario.domain.dto.LoginRequestDTO;
import com.projectoconcesionario.concesionario.domain.dto.RegisterRequestDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.AuthResponseDTO;
import com.projectoconcesionario.concesionario.domain.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final IAuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request){
        return ResponseEntity.ok(authService.login(request)) ;
    }
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO request){
        return authService.register(request);
    }
    @PostMapping("/logout")
    public ResponseEntity<AuthResponseDTO> logout(@RequestHeader("Authorization") String authorizationHeader){
        return ResponseEntity.ok(authService.logout(authorizationHeader));
    }
}
