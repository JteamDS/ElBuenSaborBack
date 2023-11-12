package com.utn.sprint3.controllers;

import com.utn.sprint3.Dto.DtoFactura;
import com.utn.sprint3.Dto.DtoNota;
import com.utn.sprint3.entidades.NotaCredito;
import com.utn.sprint3.services.NotaCreditoServicesImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "ap1/v1/nota")
public class NotaCreditoController extends BaseControllerImpl<NotaCredito, NotaCreditoServicesImpl> {
    @PostMapping("/anularFactura")
    public ResponseEntity<?> anularFactura(@RequestBody DtoNota dtoNota){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.anularFactura(dtoNota));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
}
