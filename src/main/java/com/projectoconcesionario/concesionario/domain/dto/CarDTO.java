package com.projectoconcesionario.concesionario.domain.dto;


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
    private String transmission;
    private String fuelType;
    private Integer numberSeat;
    private String traction;
    private String steering;
    private String category;
    private String imagePath;
}
