package com.projectoconcesionario.concesionario.persistance.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class CustomerEntity {
    @Id
    private String dni;
    @Column(name = "nombre_completo")
    private String fullName;
    private String email;
    @Column(name = "numero_telefono")
    private String phoneNumber;
    @Column(name = "contrasenia")
    private String password;
    @Column(name = "activo")
    private Integer active;
}
