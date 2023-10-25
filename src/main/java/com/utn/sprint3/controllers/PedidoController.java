package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.services.FacturaServicesImpl;
import com.utn.sprint3.services.PedidoServicesImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServicesImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam Date filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam Date filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
}
