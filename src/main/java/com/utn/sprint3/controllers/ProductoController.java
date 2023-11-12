package com.utn.sprint3.controllers;

import com.utn.sprint3.Dto.DtoProducto;
import com.utn.sprint3.entidades.Producto;
import com.utn.sprint3.services.ProductoServicesImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/producto")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServicesImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String nombre){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(nombre));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PostMapping("/crearProducto")
    public ResponseEntity<?> crearProducto(@RequestBody DtoProducto dtoProducto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.crearProducto(dtoProducto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String nombre, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(nombre, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }

}
