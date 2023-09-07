package com.projectoconcesionario.concesionario.domain.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private String dni;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private Integer active;
}
