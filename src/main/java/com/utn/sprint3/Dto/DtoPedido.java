package com.utn.sprint3.Dto;

import com.utn.sprint3.enumeraciones.FormaPago;
import com.utn.sprint3.enumeraciones.TipoEnvio;
import lombok.Data;

import java.util.List;

@Data
public class DtoPedido {
    String fechaPedido;
    TipoEnvio tipoEnvio;
    FormaPago formaPago;
    Long idCliente;
    Long idDomicilio;
    List<DtoPedidoProducto> productos;
}
