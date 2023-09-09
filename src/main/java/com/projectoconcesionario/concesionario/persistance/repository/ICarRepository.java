package com.projectoconcesionario.concesionario.persistance.repository;

import com.projectoconcesionario.concesionario.persistance.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICarRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllByCarBrandId(Integer carBrandId);
    @Query("SELECT c FROM CarEntity c JOIN CarBrandEntity cb ON c.carBrandId = cb.id WHERE cb.description = ?1")
    List<CarEntity> findAllByCarBrandDescription(String carBrand);
    List<CarEntity> findAllByPriceLessThanEqualOrderByPriceDesc(Double price);


}