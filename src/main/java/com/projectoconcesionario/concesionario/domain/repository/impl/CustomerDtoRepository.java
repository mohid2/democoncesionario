package com.projectoconcesionario.concesionario.domain.repository.impl;

import com.projectoconcesionario.concesionario.domain.dto.CustomerDTO;
import com.projectoconcesionario.concesionario.domain.repository.ICustomerDtoRepository;
import com.projectoconcesionario.concesionario.persistance.entity.CustomerEntity;
import com.projectoconcesionario.concesionario.persistance.mapper.ICustomerMapper;
import com.projectoconcesionario.concesionario.persistance.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class CustomerDtoRepository implements ICustomerDtoRepository {

    private final ICustomerRepository iCustomerRepository;
    private final ICustomerMapper iCustomerMapper;


    @Override
    public List<CustomerDTO> getAll() {
        return iCustomerMapper.customerEntitiesToCustomersDTOs(iCustomerRepository.findAll());
    }

    @Override
    public Optional<CustomerDTO> getCustomerDTO(String dni) {
        return iCustomerRepository.findById(dni).map(iCustomerMapper::customerEntityToCustomerDTO);
    }

    @Override
    public Optional<CustomerDTO> getCustomerDTOByEmail(String email) {
        return iCustomerRepository.findByEmail(email).map(iCustomerMapper::customerEntityToCustomerDTO);
    }

    @Override
    public CustomerDTO saveCustomerDTO(CustomerDTO customerDTO) {
        CustomerEntity customerEntity=iCustomerMapper.customerDTOToCustomerEntity(customerDTO);
        return  iCustomerMapper.customerEntityToCustomerDTO(iCustomerRepository.save(customerEntity));
    }

    @Override
    public void deleteCustomerDTO(String dni) {
        iCustomerRepository.deleteById(dni);
    }
}

