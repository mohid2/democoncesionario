package com.projectoconcesionario.concesionario.domain.repository.impl;



import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.CarDTOResponse;
import com.projectoconcesionario.concesionario.domain.dto.response.CarPurchaseResponseDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.PurchaseResponseDTO;

import com.projectoconcesionario.concesionario.domain.repository.ICarDtoRepository;
import com.projectoconcesionario.concesionario.domain.repository.IPurchaseDtoRepository;


import com.projectoconcesionario.concesionario.persistance.entity.CarPurchaseEntity;
import com.projectoconcesionario.concesionario.persistance.entity.PurchaseEntity;
import com.projectoconcesionario.concesionario.persistance.entity.mapper.IPurchaseMapper;

import com.projectoconcesionario.concesionario.persistance.repository.IPurchaseRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class PurchaseDtoRepository implements IPurchaseDtoRepository {

    private final IPurchaseRepository iPurchaseRepository;
    private final IPurchaseMapper iPurchaseMapper;
    private final ICarDtoRepository iCarDtoRepository;

    @Override
    public List<PurchaseDTO> getAll() {
        return  iPurchaseMapper.purchaseEntitiesToPurchaseDTOs(iPurchaseRepository.findAll());
    }

    @Override
    public Optional<PurchaseDTO> getPurchase(Integer id) {
        return iPurchaseRepository.findById(id).map(iPurchaseMapper::purchaseEntityToPurchaseDTO);
    }

    @Override
    public PurchaseResponseDTO savePurchase(PurchaseDTO purchaseDTO) {
        PurchaseEntity purchaseEntity = iPurchaseMapper.purchaseDTOToPurchaseEntity(purchaseDTO);

        purchaseEntity.getCarPurchaseEntityList().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity));

        PurchaseEntity purchaseEntitySave = iPurchaseRepository.save(purchaseEntity);
       List<CarPurchaseResponseDTO> carPurchaseResponseDTOS=purchaseEntitySave.getCarPurchaseEntityList().stream()
               .map(this::toDtoCarPurchaseResponseDTOs).collect(Collectors.collectingAndThen(
                       Collectors.toCollection(ArrayList::new),
                       ArrayList::new
               ));
        PurchaseResponseDTO purchaseResponseDTO= iPurchaseMapper.purchaseEntityToPurchaseResponseDTO(purchaseEntitySave);
        purchaseResponseDTO.setCarPurchaseDTOs(carPurchaseResponseDTOS);
        return purchaseResponseDTO;
    }
    private  CarPurchaseResponseDTO toDtoCarPurchaseResponseDTOs(CarPurchaseEntity carPurchaseEntities){
        Integer carCode= carPurchaseEntities.getId().getCarCode();
        return CarPurchaseResponseDTO.builder().referenceCar(getCarEntity(carCode).getReference())
                .carBrandDescription(getCarEntity(carCode).getCarBrandDescription())
                .price(getCarEntity(carCode).getPrice())
                .total(carPurchaseEntities.getTotal())
                .quantity(carPurchaseEntities.getQuantity())
                .build();
    }

    @Override
    public void deletePurchase(Integer id) {
        iPurchaseRepository.deleteById(id);
    }
    private CarDTOResponse getCarEntity(Integer codeCar) {
        Optional<CarDTOResponse> optionalCar = iCarDtoRepository.getCar(codeCar);
        return optionalCar.orElse(null);
    }

}
