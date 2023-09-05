package com.projectoconcesionario.concesionario.persistance.repository;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.domain.repository.ICarBrandCrudRepository;
import com.projectoconcesionario.concesionario.persistance.entity.CarBrandEntity;
import com.projectoconcesionario.concesionario.persistance.mapper.ICarBrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class CarBrandRepository implements ICarBrandCrudRepository {

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
