package com.projectoconcesionario.concesionario.controller;

import com.projectoconcesionario.concesionario.domain.dto.CustomerDTO;
import com.projectoconcesionario.concesionario.domain.service.ICustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de cliente
 */
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CustomerController {

    private final ICustomerService iCustomerService;

    /**
     *
     * @return lista CustomerDTO
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/clientes")
    public ResponseEntity<List<CustomerDTO>> getAll(){
        return ResponseEntity.ok(iCustomerService.getAll());
    }

    /**
     *
     * @param id del Customer a buscar
     * @return CustomerDTO
     */
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('CUSTOMER')")
    @GetMapping("/clientes/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String id){
        return ResponseEntity.of(iCustomerService.getCustomerDTO(id));
    }

    /**
     *
     * @param email del Customer a buscar
     * @return CustomerDTO
     */
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @GetMapping("/clientes/v1/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email){
        return ResponseEntity.of(iCustomerService.getCustomerDTOByEmail(email));
    }
    /**
     *
     * @param customerDTO del Customer a actualizar
     * @return CustomerDTO
     */

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/clientes")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO){
            return ResponseEntity.of(iCustomerService.updateCustomerDTO(customerDTO));
    }

    /**
     *
     * @param dni del Customer a borrar
     * @return Boolean
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable(name = "id") String dni){
        return new ResponseEntity<>(iCustomerService.deleteCustomerDTO(dni) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
