package com.projectoconcesionario.concesionario.domain.service;

import com.projectoconcesionario.concesionario.domain.dto.CustomerDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.CustomerResponseDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    /**
     * Devuelve un lista de clientesDto
     * @return lista clientes
     */
    List<CustomerDTO> getAll();

    /**
     * Devueleve una marca coche dado su id
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
    CustomerResponseDto saveCustomerDTO(CustomerDTO customerDTO );

    /**
     *
     * @param customerDTO
     * @return
     */
    Optional<CustomerDTO>  updateCustomerDTO(CustomerDTO customerDTO );

    /**
     * Elimina una marca coche dada su id
     * @param dni id cliente a eliminar
     */
    boolean deleteCustomerDTO(String dni);
}
