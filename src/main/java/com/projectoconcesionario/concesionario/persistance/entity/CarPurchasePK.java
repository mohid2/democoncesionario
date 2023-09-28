package com.projectoconcesionario.concesionario.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


import java.io.Serial;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Embeddable
public class CarPurchasePK implements Serializable {
    @Serial
    private static final long serialVersionUID = -6096095155740053978L;

    @Column(name = "compra_numero_factura")
    private Integer purchaseInvoiceNumber;
    @Column(name = "coches_codigo_coche")
    private Integer carCode;
}
