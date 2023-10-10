package com.projectoconcesionario.concesionario.domain.dto.response;

import lombok.*;

import java.time.LocalDate;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTOResponse {
    private Integer carCode;
    private String carBrandDescription;
    private String reference;
    private Double price;
    private LocalDate modelYear;
    private String color;
    private Double horsepower;
    private Integer numberDoors;
    private Double engineDisplacement;
    private String transmission;
    private String fuelType;
    private Integer numberSeat;
    private String traction;
    private String steering;
    private String category;
    private String imagePath;
}
