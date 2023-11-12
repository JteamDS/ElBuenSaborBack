package com.utn.sprint3.Dto;

import com.utn.sprint3.enumeraciones.EstadoPedido;
import lombok.Data;

@Data
public class DtoCambioEstado {
    EstadoPedido estadoPedido;
    Long idPedido;
}
