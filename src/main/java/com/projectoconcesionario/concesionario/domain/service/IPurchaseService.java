package com.projectoconcesionario.concesionario.domain.service;


import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface IPurchaseService {

    List<PurchaseDTO> getAll();



    Optional<PurchaseDTO> getPurchaseDTO(Integer invoiceNumber);

    PurchaseDTO savePurchaseDTO(PurchaseDTO purchaseDTO );


    Optional<PurchaseDTO>  updatePurchaseDTO(PurchaseDTO purchaseDTO );


    boolean deletePurchaseDTO(Integer invoiceNumber);
}
