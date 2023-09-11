package com.projectoconcesionario.concesionario.persistance.mapper;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.persistance.entity.CarBrandEntity;
import com.projectoconcesionario.concesionario.persistance.entity.CarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICarMapper {
    /**
     * convierte una CarBrandEntity a una CarBrandDTO
     * @param carEntity de tipo CarBrandEntity
     * @return  CarBrandDTO
     */
    CarDTO carEntityToCarDTO(CarEntity carEntity);

    /**
     * convierte una  CarBrandDTO a una CarBrandEntity
     * @param carDTO de tipo CarBrandDTO
     * @return  CarBrandEntity
     */
    @Mapping(target = "carBrandEntity",ignore = true)
    @Mapping(target = "carPurchaseEntityList",ignore = true)
    @InheritInverseConfiguration
    CarEntity carDTOToCarEntity(CarDTO carDTO);

    /**
     * transformar una lista de tipo CarBrandEntity a una lista CarBrandDTO
     * @param carEntities lista a transformar de tipo CarBrandEntity
     * @return una lista de tipo  CarBrandDTO
     */
    List<CarDTO> carsEntityToCarsDTO(List<CarEntity> carEntities);

    /**
     * transformar una lista de tipo CarBrandDTO  a una lista CarBrandEntity
     * @param carsDTO  lista a transformar de tipo CarBrandDTO
     * @return una lista de tipo CarBrandEntity
     */
    List<CarEntity> carsDTOToCarsEntity(List<CarDTO> carsDTO);

}
