package com.utn.sprint3.controllers;

import com.utn.sprint3.Dto.DtoCambioEstado;
import com.utn.sprint3.Dto.DtoFactura;
import com.utn.sprint3.Dto.DtoPedido;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enumeraciones.EstadoPedido;
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
    public ResponseEntity<?> search(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/buscarEstado")
    public ResponseEntity<?> buscarEstado(@RequestBody DtoCambioEstado dtoCambioEstado){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarEstado(dtoCambioEstado));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PostMapping("/crearPedido")
    public ResponseEntity<?> buscar(@RequestBody DtoPedido dtoPedido){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.crearPedido(dtoPedido));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PostMapping("/cambiarEstado")
    public ResponseEntity<?> cambiarEstado(@RequestBody DtoCambioEstado dtoCambioEstado){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarEstado(dtoCambioEstado));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PostMapping("/crearFactura")
    public ResponseEntity<?> crearFactura(@RequestBody DtoFactura dtoFactura){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.crearFactura(dtoFactura));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/verGanancias")
    public ResponseEntity<?> verGanancias(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.verGanancias());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
}
