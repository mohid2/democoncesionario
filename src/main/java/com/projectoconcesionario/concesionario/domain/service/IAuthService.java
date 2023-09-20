package com.projectoconcesionario.concesionario.domain.service;

import com.projectoconcesionario.concesionario.domain.dto.LoginRequestDTO;
import com.projectoconcesionario.concesionario.domain.dto.RegisterRequestDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.AuthResponseDTO;

public interface IAuthService {
    AuthResponseDTO register(RegisterRequestDTO request);
    AuthResponseDTO login(LoginRequestDTO request);
}
