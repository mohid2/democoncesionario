package com.projectoconcesionario.concesionario.persistance.mapper;

import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;

import com.projectoconcesionario.concesionario.persistance.entity.PurchaseEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ICarPurchaseMapper.class})
public interface IPurchaseMapper {
    @Mapping(target = "customerEntity",ignore = true)
    @Mapping(target = "carPurchaseEntityList", source = "carPurchaseDTOs")
    PurchaseEntity purchaseDTOToPurchaseEntity(PurchaseDTO purchaseDTO);
    @Mapping(target = "carPurchaseDTOs", source = "carPurchaseEntityList")
    PurchaseDTO purchaseEntityToPurchaseDTO(PurchaseEntity purchaseEntity);

    List<PurchaseDTO> purchaseEntitiesToPurchaseDTOs(List<PurchaseEntity> purchaseEntities);







}