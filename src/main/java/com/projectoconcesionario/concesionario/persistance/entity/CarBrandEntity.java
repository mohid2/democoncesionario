package com.projectoconcesionario.concesionario.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "marca_coche")
public class CarBrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", unique = true)
    private String description;

    @ToString.Exclude
    @OneToMany(mappedBy = "carBrandEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CarEntity> carEntities;

}
