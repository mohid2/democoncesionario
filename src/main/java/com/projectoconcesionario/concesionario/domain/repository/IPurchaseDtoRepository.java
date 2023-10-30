package com.projectoconcesionario.concesionario.domain.repository;

import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.PurchaseResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IPurchaseDtoRepository {

    /**
     * Devuelve un lista de  coches
     * @return lista  coches
     */
    List<PurchaseDTO> getAll();


    Optional<PurchaseDTO> getPurchase(Integer id);


    /**
     * Guardar y actualiza  coche
     * @param purchaseDTO  coche a Guardar o actualiza
     * @return  coche  Guardada o actualizada
     */
    PurchaseResponseDTO savePurchase(PurchaseDTO purchaseDTO );

    /**
     * Elimina un coche dada su id
     * @param id id coche a eliminar
     */
    void deletePurchase(Integer id);
}
