package com.projectoconcesionario.concesionario.domain.service;


import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.PurchaseResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IPurchaseService {

    List<PurchaseDTO> getAll();



    Optional<PurchaseDTO> getPurchaseDTO(Integer invoiceNumber);

    PurchaseResponseDTO savePurchaseDTO(PurchaseDTO purchaseDTO );


    Optional<PurchaseResponseDTO>  updatePurchaseDTO(PurchaseDTO purchaseDTO );


    boolean deletePurchaseDTO(Integer invoiceNumber);
}
