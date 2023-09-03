package com.projectoconcesionario.concesionario.controller;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.domain.service.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CarBrandController {
    private final ICarBrandService iCarBrandService;


    @GetMapping("/marcas")
    public ResponseEntity<List<CarBrandDTO>> getAll() {
        return ResponseEntity.ok(iCarBrandService.getAll());
    }

    @GetMapping("/marcas/{id}")
    public ResponseEntity<CarBrandDTO> getCarBrand(@PathVariable Integer id) {
       return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }
    @PostMapping("/marcas")
    public ResponseEntity<CarBrandDTO> saveCarBrand(@RequestBody CarBrandDTO carBrandDTO ){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandService.saveCarBrand(carBrandDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    //public ResponseEntity<Boolean>  deleteCarBrand(Integer id){}
}
