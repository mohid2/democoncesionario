package com.projectoconcesionario.concesionario.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDTO {
    private String dni;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String password;
}
