package com.projectoconcesionario.concesionario.domain.service.impl;

import com.projectoconcesionario.concesionario.domain.dto.CarBrandDTO;
import com.projectoconcesionario.concesionario.domain.repository.ICarBrandDtoRepository;
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

    private final ICarBrandDtoRepository iCarBrandDtoRepository;

    /**
     * Devuelve un lista de marca coches
     * @return lista marca coches
     */
    @Override
    public List<CarBrandDTO> getAll() {
        return iCarBrandDtoRepository.getAll();
    }

    /**
     * Devueleve una marca coche dado su id
     * @param id id marca coche que es de tipo Integer
     * @return Optional de marca coche encontrado
     */
    @Override
    public Optional<CarBrandDTO> getCarBrand(Integer id) {
        return iCarBrandDtoRepository.getCarBrand(id);
    }

    /**
     * Guardar y actualiza marca coche
     * @param carBrandDTO marca coche a Guardar o actualiza
     * @return marca coche  Guardada o actualizada
     */
    @Override
    public CarBrandDTO saveCarBrand(CarBrandDTO carBrandDTO) {
        return iCarBrandDtoRepository.saveCarBrand(carBrandDTO);
    }


    /**
     * Elimina una marca coche dada su id
     * @param id id marca coche a eliminar
     * @return retorna true si se elimino y falso lo contrario
     */
    @Override
    public boolean deleteCarBrand(Integer id) {
         if(getCarBrand(id).isPresent()){
             iCarBrandDtoRepository.deleteCarBrand(id);
             return true;
         }
         return false;
    }
}
