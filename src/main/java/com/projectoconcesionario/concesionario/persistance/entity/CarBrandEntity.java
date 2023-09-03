package com.projectoconcesionario.concesionario.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
@Entity
@Table(name = "marca_coche")
public class CarBrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descripcion")
    private String description;
}
