package com.projectoconcesionario.concesionario.domain.service.impl;

import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.PurchaseResponseDTO;
import com.projectoconcesionario.concesionario.domain.repository.IPurchaseDtoRepository;
import com.projectoconcesionario.concesionario.domain.service.IPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements IPurchaseService {

    private final IPurchaseDtoRepository iPurchaseDtoRepository;

    @Override
    public List<PurchaseDTO> getAll() {
        return iPurchaseDtoRepository.getAll();
    }

    @Override
    public Optional<PurchaseDTO> getPurchaseDTO(Integer invoiceNumber) {
        return iPurchaseDtoRepository.getPurchase(invoiceNumber);
    }

    @Override
    public PurchaseResponseDTO savePurchaseDTO(PurchaseDTO purchaseDTO) {
        return iPurchaseDtoRepository.savePurchase(purchaseDTO);
    }

    @Override
    public Optional<PurchaseResponseDTO> updatePurchaseDTO(PurchaseDTO purchaseDTO) {
        if (iPurchaseDtoRepository.getPurchase(purchaseDTO.getInvoiceNumber()).isPresent()){
            return Optional.of(iPurchaseDtoRepository.savePurchase(purchaseDTO));
        }
        return Optional.empty();
    }

    @Override
    public boolean deletePurchaseDTO(Integer invoiceNumber) {
        if(iPurchaseDtoRepository.getPurchase(invoiceNumber).isPresent()){
            iPurchaseDtoRepository.deletePurchase(invoiceNumber);
            return true;
        }
        return false;
    }
}
