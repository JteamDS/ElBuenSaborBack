package com.utn.sprint3.Dto;

import com.utn.sprint3.enumeraciones.EstadoRubro;
import lombok.Data;

@Data
public class DtoRubro {
    String nombre;
    EstadoRubro estadoRubro;
    Long idRubro;
}
