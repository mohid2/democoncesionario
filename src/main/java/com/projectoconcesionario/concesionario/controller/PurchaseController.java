package com.projectoconcesionario.concesionario.controller;
import com.projectoconcesionario.concesionario.domain.dto.PurchaseDTO;
import com.projectoconcesionario.concesionario.domain.dto.response.PurchaseResponseDTO;
import com.projectoconcesionario.concesionario.domain.service.IPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final IPurchaseService iPurchaseService;

    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> getAll(){
        return ResponseEntity.ok(iPurchaseService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDTO> getPurchase(@PathVariable Integer id){
        return ResponseEntity.of(iPurchaseService.getPurchaseDTO(id));
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> purchaseSave(@RequestBody PurchaseDTO purchaseDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(iPurchaseService.savePurchaseDTO(purchaseDTO));
    }

    @PutMapping()
    public ResponseEntity<PurchaseResponseDTO> updatePurchase(@RequestBody PurchaseDTO purchaseDTO){
        return ResponseEntity.of(iPurchaseService.updatePurchaseDTO(purchaseDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePurchase(@PathVariable Integer id ){
        return new ResponseEntity<>(iPurchaseService.deletePurchaseDTO(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
