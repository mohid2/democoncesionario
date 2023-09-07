package com.projectoconcesionario.concesionario.persistance.repository;

import com.projectoconcesionario.concesionario.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<CustomerEntity,String> {
    Optional<CustomerEntity> findByEmail(String email);
}
