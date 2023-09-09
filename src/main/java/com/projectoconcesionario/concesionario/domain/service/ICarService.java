package com.projectoconcesionario.concesionario.domain.service;

import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    /**
     * Devuelve un lista de  coches
     * @return lista  coches
     */
    List<CarDTO> getAll();

    /**
     * Devueleve una coche dado su id
     * @param id id de coche que es de tipo Integer
     * @return Optional de coche encontrado
     */

    Optional<CarDTO> getCar(Integer id);

    /**
     *
     * @param id
     * @return
     */
    List<CarDTO> getByCarBrandId(Integer id);

    /**
     *
     * @param id
     * @return
     */

    List<CarDTO> findAllByCarBrandDescription(String id);

    /**
     *
     * @param price
     * @return
     */
    List<CarDTO> getByPriceLessThanEqual(Double price);


    /**
     * Guardar y actualiza  coche
     * @param carDTO coche a Guardar o actualiza
     * @return  coche  Guardada o actualizada
     */
    CarDTO saveCar(CarDTO carDTO );

    /**
     *
     * @param carDTO
     * @return
     */
    Optional<CarDTO>  updateCarDTO(CarDTO carDTO);

    /**
     * Elimina un coche dada su id
     * @param id id coche a eliminar
     */
    boolean deleteCar(Integer id);
}
