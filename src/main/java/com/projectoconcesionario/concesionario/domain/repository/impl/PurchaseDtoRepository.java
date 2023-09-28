package com.projectoconcesionario.concesionario.domain.repository.impl;

import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.dto.CarPurchaseDTO;
import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;
import com.projectoconcesionario.concesionario.domain.repository.IPurchaseDtoRepository;
import com.projectoconcesionario.concesionario.persistance.entity.CarEntity;
import com.projectoconcesionario.concesionario.persistance.entity.CarPurchaseEntity;
import com.projectoconcesionario.concesionario.persistance.entity.CarPurchasePK;
import com.projectoconcesionario.concesionario.persistance.entity.PurchaseEntity;
import com.projectoconcesionario.concesionario.persistance.mapper.ICarMapper;
import com.projectoconcesionario.concesionario.persistance.mapper.ICarPurchaseMapper;
import com.projectoconcesionario.concesionario.persistance.mapper.ICustomerMapper;
import com.projectoconcesionario.concesionario.persistance.mapper.IPurchaseMapper;
import com.projectoconcesionario.concesionario.persistance.repository.ICustomerRepository;
import com.projectoconcesionario.concesionario.persistance.repository.IPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class PurchaseDtoRepository implements IPurchaseDtoRepository {

    private final IPurchaseRepository iPurchaseRepository;
    private final IPurchaseMapper iPurchaseMapper;
    private final ICarMapper iCarMapper;

    @Override
    public List<PurchaseDTO> getAll() {
        return  iPurchaseMapper.purchaseEntitiesToPurchaseDTOs(iPurchaseRepository.findAll());
    }

    @Override
    public Optional<PurchaseDTO> getPurchase(Integer id) {
        return iPurchaseRepository.findById(id).map(iPurchaseMapper::purchaseEntityToPurchaseDTO);
    }

    @Override
    public PurchaseDTO savePurchase(PurchaseDTO purchaseDTO) {
        PurchaseEntity purchaseEntity = iPurchaseMapper.purchaseDTOToPurchaseEntity(purchaseDTO);

        purchaseEntity.getCarPurchaseEntityList().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity));

        PurchaseEntity purchaseEntitySave = iPurchaseRepository.save(purchaseEntity);
        return iPurchaseMapper.purchaseEntityToPurchaseDTO(purchaseEntitySave);
    }
    @Override
    public void deletePurchase(Integer id) {

    }
}
