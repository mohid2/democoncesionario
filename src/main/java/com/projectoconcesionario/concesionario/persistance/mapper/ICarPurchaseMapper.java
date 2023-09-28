package com.projectoconcesionario.concesionario.persistance.mapper;

import com.projectoconcesionario.concesionario.domain.dto.CarPurchaseDTO;
import com.projectoconcesionario.concesionario.persistance.entity.CarPurchaseEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICarPurchaseMapper {
    @Mapping(source = "carCode", target = "id.carCode")
    @Mapping(target = "purchaseEntity", ignore = true)
    @Mapping(target = "carEntity", ignore = true)
    @Mapping(target = "id.purchaseInvoiceNumber", ignore = true)
    CarPurchaseEntity carPurchaseDTOToCarPurchaseEntity(CarPurchaseDTO carPurchaseDTO);

    @Mapping(source = "id.purchaseInvoiceNumber", target = "invoiceNumber")
    @Mapping(source = "id.carCode", target = "carCode")
    CarPurchaseDTO carPurchaseEntitytoDToCarPurchaseDTO(CarPurchaseEntity carPurchaseEntity);
}