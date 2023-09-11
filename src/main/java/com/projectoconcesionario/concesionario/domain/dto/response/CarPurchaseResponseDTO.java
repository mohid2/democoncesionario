package com.projectoconcesionario.concesionario.domain.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CarPurchaseResponseDTO {
    private String referenceCar;
    private Integer quantity;
    private Double total;
}
