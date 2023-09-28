package com.projectoconcesionario.concesionario.domain.dto;


import com.projectoconcesionario.concesionario.persistance.entity.enums.Role;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private String dni;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String password;
    private Integer active;
    private Role role;

}
