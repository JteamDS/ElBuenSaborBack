package com.utn.sprint3.Dto;

import lombok.Data;

@Data
public class DtoProducto {
    String nombre;
    String descripcion;
    float precioVenta;
    float costo;
    float stockActual;
    float stockMinimo;
    Long idUnidadMedida;
    Long idRubro;
    Long idProducto;
}
