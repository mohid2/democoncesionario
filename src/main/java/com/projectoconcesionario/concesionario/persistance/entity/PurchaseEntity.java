package com.projectoconcesionario.concesionario.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer invoiceNumber;
    @Column(name = "cliente_dni")
    private String customerDni;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Double total;
    @Column(name = "medio_pago")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "cliente_dni",insertable = false,updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "purchaseEntity",cascade = CascadeType.ALL)
    private List<CarPurchaseEntity> carPurchaseEntityList;
}
