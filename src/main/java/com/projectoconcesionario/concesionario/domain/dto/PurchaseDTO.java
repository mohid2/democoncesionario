package com.projectoconcesionario.concesionario.domain.dto;

import lombok.*;


import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PurchaseDTO {
    private Integer invoiceNumber;
    private String customerDni;
    private Date date;
    private Double total;
    private String paymentMethod;
    private List<CarPurchaseDTO> carPurchaseDTOs;
}
