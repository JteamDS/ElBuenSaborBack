package com.utn.sprint3.controllers;


import com.utn.sprint3.Dto.DtoCliente;
import com.utn.sprint3.Dto.DtoDomicilio;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.services.ClienteServicesImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServicesImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
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
    @PostMapping("/modificar")
    public ResponseEntity<?> modificarDatos(@RequestBody DtoCliente dtoCliente){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.modificarDatos(dtoCliente));
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
    @PostMapping("/agregarDom")
    public ResponseEntity<?> agregarDom(@RequestBody DtoDomicilio dtoDomicilio){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.agregarDomicilio(dtoDomicilio));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
    @DeleteMapping("/eliminarDom")
    public ResponseEntity<?> agregarDom(@RequestParam Long idCliente,Long idDomicilio){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminarDomicilio(idCliente, idDomicilio));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/verPedidos")
    public ResponseEntity<?> verPedidos(@RequestParam Long idCliente){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.verPedidos(idCliente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/clienteMasPedidos")
    public ResponseEntity<?> clienteMasPedidos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.clienteMasPedidos());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/clienteMasImporte")
    public ResponseEntity<?> clienteMasImporte(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.clienteMasImporte());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }

}
