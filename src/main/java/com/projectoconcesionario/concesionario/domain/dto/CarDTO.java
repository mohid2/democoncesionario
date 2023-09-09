package com.projectoconcesionario.concesionario.domain.dto;

import com.projectoconcesionario.concesionario.persistance.entity.enums.TractionType;
import com.projectoconcesionario.concesionario.persistance.entity.enums.TransmissionType;
import lombok.*;

import java.time.LocalDate;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private Integer carCode;
    private Integer carBrandId;
    private String reference;
    private Double price;
    private LocalDate modelYear;
    private String color;
    private Double horsepower;
    private Integer numberDoors;
    private Double engineDisplacement;
    private TransmissionType transmission;
    private String fuelType;
    private Integer numberSeat;
    private TractionType traction;
    private String steering;
    private String category;
    private String imagePath;
}
