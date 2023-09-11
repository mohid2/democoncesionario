package com.projectoconcesionario.concesionario.persistance.mapper;

import com.projectoconcesionario.concesionario.domain.dto.CustomerDTO;
import com.projectoconcesionario.concesionario.persistance.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * mapper que transforma objetos de Customer a dto o entidades
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICustomerMapper {

    /**
     * convierte una CustomerEntity a una CustomerDTO
     * @param customerEntity de tipo CustomerEntity
     * @return CustomerDTO
     */
    CustomerDTO customerEntityToCustomerDTO(CustomerEntity customerEntity);

    /**
     * Convierte una CustomerDTO a una CustomerEntity
     * @param customerDTO de tipo CustomerDTO
     * @return CustomerEntity
     */
    @Mapping(target = "purchaseEntityList",ignore = true)
    @InheritInverseConfiguration
    CustomerEntity customerDTOToCustomerEntity(CustomerDTO customerDTO);

    /**
     * Transformar una lista de tipo CustomerEntity a una lista CustomerDTO
     * @param customerEntities lista de tipo CustomerEntity
     * @return lista de tipo CustomerDTO
     */
    List<CustomerDTO> customerEntitiesToCustomersDTOs(List<CustomerEntity> customerEntities );

    /**
     * Transformar una lista de tipo CustomerDTO a una lista CustomerEntity
     * @param customersDTOs lista de tipo CustomerDTO
     * @return lista de tipo CustomerEntity
     */
    List<CustomerEntity> customersDTOsToCustomerEntities(List<CustomerDTO> customersDTOs );

}
