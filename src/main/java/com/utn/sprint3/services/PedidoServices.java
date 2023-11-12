package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoFactura;
import com.utn.sprint3.Dto.DtoPedido;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enumeraciones.EstadoPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoServices extends BaseServices<Pedido,Long> {

    List<Pedido> search(String filtro) throws Exception;
    Page<Pedido> search(String filtro, Pageable pageable) throws Exception;
    Pedido crearPedido(DtoPedido dtoPedido) throws Exception;
    List<Pedido> buscarEstado(EstadoPedido estadoPedido) throws Exception;
    Pedido cambiarEstado(Long id, EstadoPedido estado) throws Exception;
    Factura crearFactura(DtoFactura dtoFactura) throws Exception;
}
