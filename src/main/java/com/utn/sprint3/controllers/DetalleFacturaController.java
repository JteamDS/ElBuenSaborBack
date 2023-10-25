package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.services.ClienteServicesImpl;
import com.utn.sprint3.services.DetalleFacturaServicesImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/detalleFacturas")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacturaServicesImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam Integer filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam Integer filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
}
