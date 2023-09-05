package com.projectoconcesionario.concesionario.persistance.repository;

import com.projectoconcesionario.concesionario.persistance.entity.CarBrandEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICarBrandRepository extends JpaRepository<CarBrandEntity,Integer>{
    Optional<CarBrandEntity> findByDescription(String description);
}
