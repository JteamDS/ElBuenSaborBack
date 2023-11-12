package com.utn.sprint3.Dto;

import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.enumeraciones.Rol;
import lombok.Data;

import java.util.List;

@Data
public class DtoEmpleado {
    Long idEmpleado;
    String nombre;
    String apellido;
    String telefono;
    String email;
    String username;
    String password;
    Rol rol;
}
