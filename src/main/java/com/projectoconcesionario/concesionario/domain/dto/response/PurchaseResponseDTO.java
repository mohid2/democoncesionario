package com.projectoconcesionario.concesionario.domain.dto.response;


import lombok.*;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PurchaseResponseDTO {
    private Integer invoiceNumber;
    private String customerDni;
    private Date date;
    private Double total;
    private String paymentMethod;
    private List< CarPurchaseResponseDTO> carPurchaseDTOs;
}
