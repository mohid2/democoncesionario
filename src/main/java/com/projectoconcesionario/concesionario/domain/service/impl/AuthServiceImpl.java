package com.projectoconcesionario.concesionario.domain.service.impl;

import com.projectoconcesionario.concesionario.domain.dto.LoginRequestDTO;
import com.projectoconcesionario.concesionario.domain.dto.RegisterRequestDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.AuthResponseDTO;
import com.projectoconcesionario.concesionario.domain.service.IAuthService;
import com.projectoconcesionario.concesionario.domain.service.IJwtService;
import com.projectoconcesionario.concesionario.exception.EmailException;
import com.projectoconcesionario.concesionario.persistance.entity.CustomerEntity;
import com.projectoconcesionario.concesionario.persistance.entity.enums.Role;
import com.projectoconcesionario.concesionario.persistance.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final ICustomerRepository iCustomerRepository;
    private final IJwtService iJwtService;
    private static final String VALIDAREMAIL= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@".concat("[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


    @Override
    public ResponseEntity<?> register(RegisterRequestDTO request) {
        if(!request.getEmail().matches(VALIDAREMAIL)){
            throw new EmailException();
        }
        if(iCustomerRepository.findByEmail(request.getEmail()).isEmpty() && iCustomerRepository.findById(request.getDni()).isEmpty()){
            CustomerEntity customerEntity = CustomerEntity.builder()
                    .dni(request.getDni())
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .phoneNumber(request.getPhoneNumber())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .active(1)
                    .role(Role.ADMIN)
                    .build();
            iCustomerRepository.save(customerEntity);
            String jwtToken= iJwtService.generateToken(customerEntity,generateExtraClaims(customerEntity));
            AuthResponseDTO responseDTO = AuthResponseDTO.builder().message("Successfully registered.").token(jwtToken).build();
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
        AuthResponseDTO responseDTO = AuthResponseDTO.builder().message("Duplicated user.").build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
         CustomerEntity customerEntity = iCustomerRepository.findByEmail(request.getEmail()).orElseThrow();
            String jwtToken= iJwtService.generateToken(customerEntity,generateExtraClaims(customerEntity));
            return AuthResponseDTO.builder().message("Se ha autenticado con exito").token(jwtToken).build();
    }

    private Map<String,Object> generateExtraClaims(CustomerEntity user) {
        Map<String,Object> extraClaims= new HashMap<>();
        extraClaims.put("firstname",user.getFirstname());
        extraClaims.put("lastname",user.getLastname());
        extraClaims.put("role",user.getRole());
        return extraClaims;
    }
}
