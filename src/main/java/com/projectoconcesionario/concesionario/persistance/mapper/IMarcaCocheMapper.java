package com.projectoconcesionario.concesionario.persistance.mapper;

import com.projectoconcesionario.concesionario.domain.DTO.MarcaCocheDTO;
import com.projectoconcesionario.concesionario.persistance.entity.MarcaCocheEntity;
import org.mapstruct.*;

import java.util.List;

/**
 * mapper que transforma objetos de MarcaCoche a pojos o entidades
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IMarcaCocheMapper {
    /**
     * convierte una MarcaCocheEntity a una MarcaCocheDTO
     * @param marcaCocheEntity  MarcaCocheEntity
     * @return  MarcaCocheEntity
     */
// esta anotacion si los atributos de la entity y el dto se llaman igual se puede omitir
    @Mapping(source = "id",target = "id")
    @Mapping(source = "description",target = "description")
    MarcaCocheDTO marcaCocheEntityToMarcaCocheDTO(MarcaCocheEntity marcaCocheEntity);

    /**
     * convierte una  MarcaCocheDTO a una MarcaCocheEntity
     * @param marcaCocheDTO MarcaCocheDTO
     * @return  MarcaCocheDTO
     */
    @InheritInverseConfiguration
    MarcaCocheEntity marcaCocheDTOToMarcaCocheEntity(MarcaCocheDTO marcaCocheDTO);

    /**
     * transformar una lista de tipo MarcaCocheEntity a una lista MarcaCocheDTO
     * @param marcaCocheEntities tipo lista a transformar
     * @return  MarcaCocheDTO tipo lista transformada
     */
    List<MarcaCocheDTO> marcasCocheEntityToMarcasCocheDTO(List<MarcaCocheEntity> marcaCocheEntities);

    /**
     * transformar una lista de tipo MarcaCocheDTO  a una lista MarcaCocheEntity
     * @param marcasCocheDTO tipo lista a transformar
     * @return  MarcaCocheEntity tipo lista transformada
     */
    List<MarcaCocheEntity> marcasCocheDTOToMarcasCocheEntity(List<MarcaCocheDTO> marcasCocheDTO);
}
