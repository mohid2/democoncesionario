package com.projectoconcesionario.concesionario.persistance.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coches")
public class CarEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1671320768031045626L;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
    @Column(name = "transmision")
    private String transmission;
    @Column(name = "tipo_cumbustible")
    private String fuelType;
    @Column(name = "cantidad_asientos")
    private Integer numberSeat;
    @Column(name = "traccion")
    private String traction;
    @Column(name = "direccion")
    private String steering;
    @Column(name = "categoria")
    private String category;
    @Column(name = "ruta_imagen")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "marca_cocheid",insertable = false,updatable = false)
    private CarBrandEntity carBrandEntity;

    @OneToMany(mappedBy = "carEntity",cascade = CascadeType.ALL)
    private List<CarPurchaseEntity> carPurchaseEntityList;
}
