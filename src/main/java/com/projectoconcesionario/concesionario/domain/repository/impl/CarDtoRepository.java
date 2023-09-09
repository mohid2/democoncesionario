package com.projectoconcesionario.concesionario.domain.repository.impl;

import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.repository.ICarDtoRepository;
import com.projectoconcesionario.concesionario.persistance.mapper.ICarMapper;
import com.projectoconcesionario.concesionario.persistance.repository.ICarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class CarDtoRepository implements ICarDtoRepository {

    private final ICarRepository iCarRepository;
    private final ICarMapper iCarMapper;
    @Override
    public List<CarDTO> getAll() {
        return iCarMapper.carsEntityToCarsDTO(iCarRepository.findAll());
    }

    @Override
    public List<CarDTO> findAllByCarBrandDescription(String description) {
        return iCarMapper.carsEntityToCarsDTO(iCarRepository.findAllByCarBrandDescription(description));
    }

    @Override
    public List<CarDTO> getByCarBrandId(Integer id) {
        return iCarMapper.carsEntityToCarsDTO(iCarRepository.findAllByCarBrandId(id));
    }

    @Override
    public List<CarDTO> getByPriceLessThanEqual(Double price) {
        return iCarMapper.carsEntityToCarsDTO(iCarRepository.findAllByPriceLessThanEqualOrderByPriceDesc(price));
    }

    @Override
    public Optional<CarDTO> getCar(Integer id) {
        return iCarRepository.findById(id).map(iCarMapper::carEntityToCarDTO);
    }

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        return iCarMapper.carEntityToCarDTO(iCarRepository.save(iCarMapper.carDTOToCarEntity(carDTO)));
    }

    @Override
    public void deleteCar(Integer id) {
        iCarRepository.deleteById(id);
    }
}
