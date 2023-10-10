package com.projectoconcesionario.concesionario.domain.repository.impl;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.domain.repository.ICarBrandDtoRepository;
import com.projectoconcesionario.concesionario.persistance.entity.mapper.ICarBrandMapper;
import com.projectoconcesionario.concesionario.persistance.repository.ICarBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class CarBrandDtoRepository implements ICarBrandDtoRepository {

    private final ICarBrandRepository iCarBrandRepository;
    private final ICarBrandMapper iCarBrandMapper;

    @Override
    public List<CarBrandDTO> getAll() {
        return iCarBrandMapper.carsBrandEntityToCarsBrandDTO(iCarBrandRepository.findAll());
    }

    @Override
    public Optional<CarBrandDTO> getCarBrand(Integer id) {
        return iCarBrandRepository.findById(id).map(iCarBrandMapper::carBrandEntityToCarBrandDTO);
    }

    @Override
    public Optional<CarBrandDTO> getCarBrandByDescription(String description) {
        return iCarBrandRepository.findByDescription(description).map(iCarBrandMapper::carBrandEntityToCarBrandDTO);
    }

    @Override
    public CarBrandDTO saveCarBrand(CarBrandDTO carBrandDTO) {
        var carBrandEntity= iCarBrandMapper.carBrandDTOToCarBrandEntity(carBrandDTO);
        carBrandEntity = iCarBrandRepository.save(carBrandEntity);
        return iCarBrandMapper.carBrandEntityToCarBrandDTO(carBrandEntity);
    }

    @Override
    public void deleteCarBrand(Integer id) {
        iCarBrandRepository.deleteById(id);
    }
}
