package com.projectoconcesionario.concesionario.domain.repository.impl;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.CarDTOResponse;
import com.projectoconcesionario.concesionario.domain.repository.ICarBrandDtoRepository;
import com.projectoconcesionario.concesionario.domain.repository.ICarDtoRepository;

import com.projectoconcesionario.concesionario.persistance.entity.CarEntity;
import com.projectoconcesionario.concesionario.persistance.entity.mapper.ICarMapper;
import com.projectoconcesionario.concesionario.persistance.repository.ICarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class CarDtoRepository implements ICarDtoRepository {

    private final ICarRepository iCarRepository;
    private final ICarMapper iCarMapper;
    private final ICarBrandDtoRepository iCarBrandDtoRepository;
    @Override
    public List<CarDTOResponse> getAll() {
        List<CarEntity> carEntities= iCarRepository.findAll();
        return  carEntities.stream().map(this::carEntityToCarDtoResponse).collect(Collectors.collectingAndThen(
                Collectors.toCollection(ArrayList::new),
                ArrayList::new
        ));
    }

    @Override
    public List<CarDTOResponse> findAllByCarBrandDescription(String description) {
        List<CarEntity> carEntities = iCarRepository.findAllByCarBrandDescription(description);
        return  carEntities.stream().map(this::carEntityToCarDtoResponse).collect(Collectors.collectingAndThen(
                Collectors.toCollection(ArrayList::new),
                ArrayList::new
        ));
    }

    @Override
    public List<CarDTOResponse> getByCarBrandId(Integer id) {
        List<CarEntity> carEntities =  iCarRepository.findAllByCarBrandId(id);
        return carEntities.stream().map(this::carEntityToCarDtoResponse).collect(Collectors.collectingAndThen(
                Collectors.toCollection(ArrayList::new),
                ArrayList::new
        ));
    }

    @Override
    public List<CarDTOResponse> getByPriceLessThanEqual(Double price) {
        List<CarEntity> carEntities = iCarRepository.findAllByPriceLessThanEqualOrderByPriceDesc(price);
        return carEntities.stream().map(this::carEntityToCarDtoResponse).collect(Collectors.collectingAndThen(
                Collectors.toCollection(ArrayList::new),
                ArrayList::new
        ));
    }

    @Override
    public Optional<CarDTOResponse> getCar(Integer id) {
        return iCarRepository.findById(id).map(this::carEntityToCarDtoResponse);
    }

    @Override
    public CarDTOResponse saveCar(CarDTO carDTO) {
        return carEntityToCarDtoResponse(iCarRepository.save(iCarMapper.carDTOToCarEntity(carDTO)));
    }


    @Override
    public void deleteCar(Integer id) {
        iCarRepository.deleteById(id);
    }

    private CarDTOResponse carEntityToCarDtoResponse(CarEntity carEntity){
        return CarDTOResponse.builder()
                .carCode(carEntity.getCarCode())
                .carBrandDescription(getCarBrandOfCarEntity(carEntity))
                .reference(carEntity.getReference())
                .price(carEntity.getPrice())
                .modelYear(carEntity.getModelYear())
                .color(carEntity.getColor())
                .horsepower(carEntity.getHorsepower())
                .numberDoors(carEntity.getNumberDoors())
                .engineDisplacement(carEntity.getEngineDisplacement())
                .transmission(carEntity.getTransmission())
                .fuelType(carEntity.getFuelType())
                .numberSeat(carEntity.getNumberSeat())
                .traction(carEntity.getTraction())
                .steering(carEntity.getSteering())
                .category(carEntity.getCategory())
                .imagePath(carEntity.getImagePath()).build();
    }

    private String getCarBrandOfCarEntity(CarEntity carEntity) {
        Optional<CarBrandDTO> optionalCarBrand = iCarBrandDtoRepository.getCarBrand(carEntity.getCarBrandId());
        return optionalCarBrand.isPresent() ? optionalCarBrand.get().getDescription() : "Not Found";
    }
}
