package com.projectoconcesionario.concesionario.domain.service.impl;

import com.projectoconcesionario.concesionario.domain.dto.CustomerDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.CustomerResponseDto;
import com.projectoconcesionario.concesionario.domain.repository.ICustomerCrudRepository;
import com.projectoconcesionario.concesionario.domain.service.ICustomerService;
import com.projectoconcesionario.concesionario.exception.EmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ICustomerServiceImpl implements ICustomerService {

    private final ICustomerCrudRepository iCustomerCrudRepository;

    private static final String VALIDAREMAIL= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@".concat("[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    /**
     * Devuelve un lista de clientesDto
     * @return lista clientes
     */
    @Override
    public List<CustomerDTO> getAll() {
        return iCustomerCrudRepository.getAll();
    }

    /**
     * Devueleve una marca coche dado su id
     * @param dni id cliente que es de tipo string
     * @return Optional de cliente encontrado
     */
    @Override
    public Optional<CustomerDTO> getCustomerDTO(String dni) {
        return iCustomerCrudRepository.getCustomerDTO(dni);
    }

    /**
     * Devueleve una cliente dado su email
     * @param email cliente que es de tipo string
     * @return  Optional de cliente encontrado
     */
    @Override
    public Optional<CustomerDTO> getCustomerDTOByEmail(String email) {
        return iCustomerCrudRepository.getCustomerDTOByEmail(email);
    }

    /**
     * Guardar cliente nuevo
     * @param customerDTO cliente a Guardar
     * @return password generado por defecto al cliente Guardada
     */
    @Override
    public CustomerResponseDto saveCustomerDTO(CustomerDTO customerDTO) {
        customerDTO.setPassword(generateRandomPassword());
        customerDTO.setActive(1);
        if(!customerDTO.getEmail().matches(VALIDAREMAIL)){
            throw new EmailException();
        }
        var customerResponseDto = iCustomerCrudRepository.saveCustomerDTO(customerDTO);
        return new CustomerResponseDto(customerResponseDto.getPassword());
    }

    /**
     * Actualizar cliente
     * @param customerDTO cliente a actualizar
     * @return  cliente actualizada
     */

    @Override
    public Optional<CustomerDTO>  updateCustomerDTO(CustomerDTO customerDTO) {
        if(iCustomerCrudRepository.getCustomerDTO(customerDTO.getDni()).isPresent()){
            return Optional.of(iCustomerCrudRepository.saveCustomerDTO(customerDTO));
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
            iCustomerCrudRepository.deleteCustomerDTO(dni);
            return true;
        }
        return false;
    }

    /**
     * Generado de password por  defecto
     * @return password generado por defecto
     */
    private  String generateRandomPassword()
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
