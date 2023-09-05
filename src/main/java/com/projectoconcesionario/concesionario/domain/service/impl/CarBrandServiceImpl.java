package com.projectoconcesionario.concesionario.domain.service.impl;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.domain.repository.ICarBrandCrudRepository;
import com.projectoconcesionario.concesionario.domain.service.ICarBrandService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarBrandServiceImpl implements ICarBrandService {

    private final ICarBrandCrudRepository iCarBrandCrudRepository;
    @Override
    public List<CarBrandDTO> getAll() {
        return iCarBrandCrudRepository.getAll();
    }

    @Override
    public Optional<CarBrandDTO> getCarBrand(Integer id) {
        return iCarBrandCrudRepository.getCarBrand(id);
    }

    @Override
    public Optional<CarBrandDTO> getCarBrandByDescription(String description) {
        return iCarBrandCrudRepository.getCarBrandByDescription(description);
    }

    @Override
    public CarBrandDTO saveCarBrand(CarBrandDTO carBrandDTO) {
        return iCarBrandCrudRepository.saveCarBrand(carBrandDTO);
    }


    @Override
    public boolean deleteCarBrand(Integer id) {
         if(getCarBrand(id).isPresent()){
             iCarBrandCrudRepository.deleteCarBrand(id);
             return true;
         }
         return false;
    }
}
