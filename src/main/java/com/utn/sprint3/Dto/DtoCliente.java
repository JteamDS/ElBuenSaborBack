package com.utn.sprint3.Dto;

import com.utn.sprint3.entidades.Domicilio;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class DtoCliente {
    Long idCliente;
    String nombre;
    String apellido;
    String telefono;
    String email;
    List<Domicilio> domicilio;
    String username;
    String password;
}
