package com.projectoconcesionario.concesionario.domain.service;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;

import java.util.List;
import java.util.Optional;

public interface ICarBrandService {
    /**
     * Devuelve un lista de marca coches
     * @return lista marca coches
     */
    List<CarBrandDTO> getAll();

    /**
     * Devueleve una marca coche dado su id
     * @param id id marca coche que es de tipo Integer
     * @return Optional de marca coche encontrado
     */
    Optional<CarBrandDTO> getCarBrand(Integer id);


    /**
     * Guardar y actualiza marca coche
     * @param carBrandDTO marca coche a Guardar o actualiza
     * @return marca coche  Guardada o actualizada
     */
    CarBrandDTO saveCarBrand(CarBrandDTO carBrandDTO );



    /**
     * Elimina una marca coche dada su id
     * @param id id marca coche a eliminar
     * @return retorna true si se elimino y falso lo contrario
     */
    boolean deleteCarBrand(Integer id);
}
