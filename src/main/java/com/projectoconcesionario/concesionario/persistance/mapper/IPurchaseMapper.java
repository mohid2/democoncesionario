package com.projectoconcesionario.concesionario.persistance.mapper;

import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;

import com.projectoconcesionario.concesionario.persistance.entity.PurchaseEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ICarPurchaseMapper.class})
public interface IPurchaseMapper {
    @Mapping(target = "customerEntity",ignore = true)
    PurchaseEntity purchaseDTOToPurchaseEntity(PurchaseDTO purchaseDTO);

}