package com.projectoconcesionario.concesionario.domain.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CarPurchaseResponseDTO {
    private String referenceCar;
    private String carBrandDescription;
    private Double price;
    private Integer quantity;
    private Double total;
}
