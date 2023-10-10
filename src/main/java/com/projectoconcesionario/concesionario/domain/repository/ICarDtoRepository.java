package com.projectoconcesionario.concesionario.domain.repository;

import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.CarDTOResponse;


import java.util.List;
import java.util.Optional;

public interface ICarDtoRepository {
    /**
     * Devuelve un lista de  coches
     * @return lista  coches
     */
    List<CarDTOResponse> getAll();

    /**
     *
     * @param id
     * @return
     */

    List<CarDTOResponse> getByCarBrandId(Integer id);

    /**
     *
     * @param description
     * @return
     */
    List<CarDTOResponse> findAllByCarBrandDescription(String description);

    /**
     *
     * @param price
     * @return
     */
    List<CarDTOResponse> getByPriceLessThanEqual(Double price);
    /**
     * Devueleve una coche dado su id
     * @param id id de coche que es de tipo Integer
     * @return Optional de coche encontrado
     */

    Optional<CarDTOResponse> getCar(Integer id);


    /**
     * Guardar y actualiza  coche
     * @param carDTO coche a Guardar o actualiza
     * @return  coche  Guardada o actualizada
     */
    CarDTOResponse saveCar(CarDTO carDTO );

    /**
     * Elimina un coche dada su id
     * @param id id coche a eliminar
     */
    void deleteCar(Integer id);


}
