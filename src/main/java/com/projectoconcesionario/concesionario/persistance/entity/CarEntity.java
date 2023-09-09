package com.projectoconcesionario.concesionario.persistance.entity;


import com.projectoconcesionario.concesionario.persistance.entity.enums.TractionType;
import com.projectoconcesionario.concesionario.persistance.entity.enums.TransmissionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coches")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche")
    private Integer carCode;
    @Column(name = "marca_cocheid")
    private Integer carBrandId;
    @Column(name = "referencia")
    private String reference;
    @Column(name = "precio")
    private Double price;
    @Column(name = "anio_modelo")
    private LocalDate modelYear;
    @Column(name = "color")
    private String color;
    @Column(name = "caballos")
    private Double horsepower;
    @Column(name = "numero_puertas")
    private Integer numberDoors;
    @Column(name = "cilindraje")
    private Double engineDisplacement;
    @Basic(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(name = "transmision")
    private TransmissionType transmission;
    @Column(name = "tipo_cumbustible")
    private String fuelType;
    @Column(name = "cantidad_asientos")
    private Integer numberSeat;
    @Enumerated(EnumType.STRING)
    @Column(name = "traccion")
    private TractionType traction;
    @Column(name = "direccion")
    private String steering;
    @Column(name = "categoria")
    private String category;
    @Column(name = "ruta_imagen")
    private String imagePath;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "marca_coche_id",insertable = false,updatable = false)
    private CarBrandEntity carBrandEntity;

}
