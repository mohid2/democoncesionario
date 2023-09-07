package com.projectoconcesionario.concesionario.persistance.mapper;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.persistance.entity.CarBrandEntity;
import org.mapstruct.*;

import java.util.List;

/**
 * mapper que transforma objetos de MarcaCoche a dto o entidades
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICarBrandMapper {
    /**
     * convierte una CarBrandEntity a una CarBrandDTO
     * @param carBrandEntity de tipo CarBrandEntity
     * @return  CarBrandDTO
     */
     // Esta annotation si los atributos de la entity y el dto. Se llaman igual se puede omitir
    @Mapping(source = "id",target = "id")
    @Mapping(source = "description",target = "description")
    CarBrandDTO carBrandEntityToCarBrandDTO(CarBrandEntity carBrandEntity);

    /**
     * convierte una  CarBrandDTO a una CarBrandEntity
     * @param carBrandDTO de tipo CarBrandDTO
     * @return  CarBrandEntity
     */
    @InheritInverseConfiguration
    CarBrandEntity carBrandDTOToCarBrandEntity(CarBrandDTO carBrandDTO);

    /**
     * transformar una lista de tipo CarBrandEntity a una lista CarBrandDTO
     * @param carsBrandEntities lista a transformar de tipo CarBrandEntity
     * @return una lista de tipo  CarBrandDTO
     */
    List<CarBrandDTO> carsBrandEntityToCarsBrandDTO(List<CarBrandEntity> carsBrandEntities);

    /**
     * transformar una lista de tipo CarBrandDTO  a una lista CarBrandEntity
     * @param carsBrandDTO  lista a transformar de tipo CarBrandDTO
     * @return una lista de tipo CarBrandEntity
     */
    List<CarBrandEntity> carsBrandDTOToCarsBrandEntity(List<CarBrandDTO> carsBrandDTO);
}
