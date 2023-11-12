package com.utn.sprint3.controllers;

import com.utn.sprint3.Dto.DtoRubro;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.services.PedidoServicesImpl;
import com.utn.sprint3.services.RubroArticuloServicesImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/rubroArticulos")
public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServicesImpl>{

    @GetMapping("/buscarCategoria")
    public ResponseEntity<?> buscarCategoria(@RequestParam String nombre){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorCategoria(nombre));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PostMapping("/modificarRubro")
    public ResponseEntity<?> modificarRubro(@RequestBody DtoRubro dtoRubro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.modificarRubro(dtoRubro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
