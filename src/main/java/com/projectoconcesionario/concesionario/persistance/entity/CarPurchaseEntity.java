package com.projectoconcesionario.concesionario.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "coches_compra")
public class CarPurchaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6315257342621332561L;

    @Id
    private CarPurchasePK id;
    @Column(name = "cantidad")
    private Integer quantity;
    private Double total;
    @ManyToOne
    @MapsId(value = "purchaseInvoiceNumber")
    @JoinColumn(name = "compra_numero_factura",insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;
    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche",insertable = false, updatable = false)
    private CarEntity carEntity;
}
