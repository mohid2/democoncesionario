package com.projectoconcesionario.concesionario.controller;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.domain.service.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/marcas")
@RestController
public class CarBrandController {
    private final ICarBrandService iCarBrandService;


    /**
     * Devuelve una lista de todas las marcas coche que hay en la base de datos
     * @return un lista CarBrandDTO
     */
    @GetMapping
    public ResponseEntity<List<CarBrandDTO>> getAll() {
        return ResponseEntity.ok(iCarBrandService.getAll());
    }

    /**
     * devuelve una marca coche dado su id
     * @param id id de la marca coche a buscar
     * @return una marca coche CarBrandDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<CarBrandDTO> getCarBrand(@PathVariable Integer id) {
       return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    /**
     * Crear una nueva marca coche si no existe
     * @param carBrandDTO marca coche a guardar
     * @return marca coche guardada y un bad request si algo falla
     */
    @PostMapping
    public ResponseEntity<CarBrandDTO> saveCarBrand(@RequestBody CarBrandDTO carBrandDTO ){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandService.saveCarBrand(carBrandDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualizar una marca coche si existe
     * @param carBrandDTO marca coche a actualizar
     * @return un status ok,marca coche actualizada  y si no un not found
     */
    @PutMapping()
    public ResponseEntity<CarBrandDTO> updateCarBrand(@RequestBody CarBrandDTO carBrandDTO ){
        if(iCarBrandService.getCarBrand(carBrandDTO.getId()).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(iCarBrandService.saveCarBrand(carBrandDTO));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Borrar una marca coche si existe
     * @param id id de la marca coche a borrar
     * @return una boolean si se ha borrado o no
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteCarBrand(@PathVariable Integer id){
        return new ResponseEntity<>(iCarBrandService.deleteCarBrand(id) ? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
