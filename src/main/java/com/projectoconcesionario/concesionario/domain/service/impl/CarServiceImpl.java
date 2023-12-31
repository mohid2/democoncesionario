package com.projectoconcesionario.concesionario.domain.service.impl;

import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.CarDTOResponse;
import com.projectoconcesionario.concesionario.domain.repository.ICarDtoRepository;
import com.projectoconcesionario.concesionario.domain.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CarServiceImpl implements ICarService {

    private final ICarDtoRepository iCarDtoRepository;
    @Override
    public List<CarDTOResponse> getAll() {
        return iCarDtoRepository.getAll();
    }

    @Override
    public Optional<CarDTOResponse> getCar(Integer id) {
        return iCarDtoRepository.getCar(id);
    }

    @Override
    public List<CarDTOResponse> getByCarBrandId(Integer id) {
        return iCarDtoRepository.getByCarBrandId(id);
    }

    @Override
    public List<CarDTOResponse> findAllByCarBrandDescription(String description) {
        return iCarDtoRepository.findAllByCarBrandDescription(description);
    }

    @Override
    public List<CarDTOResponse> getByPriceLessThanEqual(Double price) {
        return iCarDtoRepository.getByPriceLessThanEqual(price);
    }

    @Override
    public CarDTOResponse saveCar(CarDTO carDTO) {

        return iCarDtoRepository.saveCar(carDTO);
    }

    @Override
    public Optional<CarDTOResponse> updateCarDTO(CarDTO carDTO) {
        if (iCarDtoRepository.getCar(carDTO.getCarCode()).isPresent()){
            return Optional.of(iCarDtoRepository.saveCar(carDTO));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteCar(Integer id) {
        if(iCarDtoRepository.getCar(id).isPresent()){
            iCarDtoRepository.deleteCar(id);
            return true;
        }
        return false;
    }
}
