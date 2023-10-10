package com.projectoconcesionario.concesionario.domain.service;

import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.CarDTOResponse;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    /**
     * Devuelve un lista de  coches
     * @return lista  coches
     */
    List<CarDTOResponse> getAll();

    /**
     * Devueleve una coche dado su id
     * @param id id de coche que es de tipo Integer
     * @return Optional de coche encontrado
     */

    Optional<CarDTOResponse> getCar(Integer id);

    /**
     *
     * @param id
     * @return
     */
    List<CarDTOResponse> getByCarBrandId(Integer id);

    /**
     *
     * @param id
     * @return
     */

    List<CarDTOResponse> findAllByCarBrandDescription(String id);

    /**
     *
     * @param price
     * @return
     */
    List<CarDTOResponse> getByPriceLessThanEqual(Double price);


    /**
     * Guardar y actualiza  coche
     * @param carDTO coche a Guardar o actualiza
     * @return  coche  Guardada o actualizada
     */
    CarDTOResponse saveCar(CarDTO carDTO );

    /**
     *
     * @param carDTO
     * @return
     */
    Optional<CarDTOResponse>  updateCarDTO(CarDTO carDTO);

    /**
     * Elimina un coche dada su id
     * @param id id coche a eliminar
     */
    boolean deleteCar(Integer id);
}
