package com.projectoconcesionario.concesionario.persistance.repository;

import com.projectoconcesionario.concesionario.persistance.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseRepository extends JpaRepository<PurchaseEntity, Integer> {
}