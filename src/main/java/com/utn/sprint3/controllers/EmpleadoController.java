package com.utn.sprint3.controllers;

import com.utn.sprint3.Dto.DtoCliente;
import com.utn.sprint3.Dto.DtoEmpleado;
import com.utn.sprint3.entidades.Empleado;
import com.utn.sprint3.services.EmpleadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl> {
    @PostMapping("/crearEmpleado")
    public ResponseEntity<?> crearEmpleado(@RequestBody DtoEmpleado dtoEmpleado){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.crearEmpleado(dtoEmpleado));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PostMapping("/modificar")
    public ResponseEntity<?> modificarDatos(@RequestBody DtoEmpleado dtoEmpleado){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.modificarDatos(dtoEmpleado));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/verDatos")
    public ResponseEntity<?> verDatos(@RequestParam Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.verDatos(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
}
