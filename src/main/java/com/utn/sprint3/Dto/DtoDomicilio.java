package com.utn.sprint3.Dto;

import lombok.Data;
@Data
public class DtoDomicilio {
    String calle;
    Integer numero;
    Integer codigoPostal;
    String localidad;
    Long idCliente;
}
