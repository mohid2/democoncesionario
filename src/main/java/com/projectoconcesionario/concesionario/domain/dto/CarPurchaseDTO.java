package com.projectoconcesionario.concesionario.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CarPurchaseDTO {
    private Integer invoiceNumber;
    private Integer carCode;
    private Integer quantity;
    private Double total;
}
