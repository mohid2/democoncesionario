package com.projectoconcesionario.concesionario.controller;

import com.projectoconcesionario.concesionario.domain.dto.CarDTO;
import com.projectoconcesionario.concesionario.domain.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/coches")
public class CarController {
    private final ICarService iCarService;
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll(){
        return ResponseEntity.ok(iCarService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Integer id){
        return ResponseEntity.of(iCarService.getCar(id));
    }
    @GetMapping("/marcasid/{carBrandId}")
    public ResponseEntity<List<CarDTO>> getByCarBrandId(@PathVariable Integer carBrandId){
        return ResponseEntity.ok(iCarService.getByCarBrandId(carBrandId)) ;
    }
    @GetMapping("/marcas/{description}")
    public ResponseEntity<List<CarDTO>> getAllByCarBrandDescription(@PathVariable String description){
        return ResponseEntity.ok(iCarService.findAllByCarBrandDescription(description)) ;
    }
    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<CarDTO>>  getByPriceLessThanEqual(@PathVariable Double precio){
        return ResponseEntity.ok(iCarService.getByPriceLessThanEqual(precio));
    }

    @PostMapping
    public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCarService.saveCar(carDTO));
    }

    @PutMapping()
    public ResponseEntity<CarDTO> updateCustomer(@RequestBody  CarDTO carDTO){
        return ResponseEntity.of(iCarService.updateCarDTO(carDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable Integer id ){
        return new ResponseEntity<>(iCarService.deleteCar(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
