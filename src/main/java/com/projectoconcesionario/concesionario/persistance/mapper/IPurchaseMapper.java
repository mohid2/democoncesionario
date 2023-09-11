package com.projectoconcesionario.concesionario.persistance.mapper;

import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;

import com.projectoconcesionario.concesionario.persistance.entity.PurchaseEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.Scanner;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IPurchaseMapper {

    PurchaseDTO purchaseEntityToPurchaseDTO(PurchaseEntity purchaseEntity);

    @Mapping(target = "customerEntity",ignore = true)
    @InheritInverseConfiguration
    PurchaseEntity purchaseDTOToPurchaseEntity(PurchaseDTO purchaseDTO);

    List<PurchaseDTO> purchaseEntitiesToPurchaseDTOs(List<PurchaseEntity> purchaseEntities);

    List<PurchaseEntity> purchaseDTOsToPurchaseEntities(List<PurchaseDTO> purchaseDTOs);

}