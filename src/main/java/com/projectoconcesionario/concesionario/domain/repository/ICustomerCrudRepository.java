package com.projectoconcesionario.concesionario.domain.repository;

import com.projectoconcesionario.concesionario.domain.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface ICustomerCrudRepository {
    /**
     * Devuelve un lista de clientesDto
     * @return lista clientes
     */
    List<CustomerDTO> getAll();

    /**
     * Devueleve una cliente dado su id
     * @param dni id cliente que es de tipo string
     * @return Optional de cliente encontrado
     */

    Optional<CustomerDTO> getCustomerDTO(String dni);

    /**
     * Devueleve una cliente dado su email
     * @param email cliente que es de tipo string
     * @return  Optional de cliente encontrado
     */
    Optional<CustomerDTO> getCustomerDTOByEmail(String email);


    /**
     * Guardar y actualiza marca coche
     * @param customerDTO marca coche a Guardar o actualiza
     * @return cliente  Guardada o actualizada
     */
    CustomerDTO saveCustomerDTO(CustomerDTO customerDTO );

    /**
     * Elimina una marca coche dada su id
     * @param dni id cliente a eliminar
     */
    void deleteCustomerDTO(String dni);
}
