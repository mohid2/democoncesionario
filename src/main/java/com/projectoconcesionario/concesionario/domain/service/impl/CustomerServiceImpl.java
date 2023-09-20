package com.projectoconcesionario.concesionario.domain.service.impl;

import com.projectoconcesionario.concesionario.domain.dto.CustomerDTO;

import com.projectoconcesionario.concesionario.domain.repository.ICustomerDtoRepository;
import com.projectoconcesionario.concesionario.domain.service.ICustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerDtoRepository iCustomerDtoRepository;

    /**
     * Devuelve un lista de clientesDto
     * @return lista clientes
     */
    @Override
    public List<CustomerDTO> getAll() {
        return iCustomerDtoRepository.getAll();
    }

    /**
     * Devueleve una marca coche dado su id
     * @param dni id cliente que es de tipo string
     * @return Optional de cliente encontrado
     */
    @Override
    public Optional<CustomerDTO> getCustomerDTO(String dni) {
        return iCustomerDtoRepository.getCustomerDTO(dni);
    }

    /**
     * Devueleve una cliente dado su email
     * @param email cliente que es de tipo string
     * @return  Optional de cliente encontrado
     */
    @Override
    public Optional<CustomerDTO> getCustomerDTOByEmail(String email) {
        return iCustomerDtoRepository.getCustomerDTOByEmail(email);
    }



    /**
     * Actualizar cliente
     * @param customerDTO cliente a actualizar
     * @return  cliente actualizada
     */

    @Override
    public Optional<CustomerDTO>  updateCustomerDTO(CustomerDTO customerDTO) {
        if(iCustomerDtoRepository.getCustomerDTO(customerDTO.getDni()).isPresent()){
            return Optional.of(iCustomerDtoRepository.saveCustomerDTO(customerDTO));
        }
        return Optional.empty();
    }

    /**
     * Elimina un cliente  dada su id
     * @param dni id cliente a eliminar
     *@return retorna true si se elimino y falso lo contrario
     */
    @Override
    public boolean deleteCustomerDTO(String dni) {
        if(getCustomerDTO(dni).isPresent()){
            iCustomerDtoRepository.deleteCustomerDTO(dni);
            return true;
        }
        return false;
    }
}
