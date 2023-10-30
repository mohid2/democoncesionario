package com.projectoconcesionario.concesionario.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "marca_coche")
public class CarBrandEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -3061576191628493640L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", unique = true)
    private String description;

    @OneToMany(mappedBy = "carBrandEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CarEntity> carEntities;
}
