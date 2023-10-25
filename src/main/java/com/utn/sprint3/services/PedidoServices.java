package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoServices extends BaseServices<Pedido,Long> {

    List<Pedido> search(java.util.Date filtro) throws Exception;
    Page<Pedido> search(java.util.Date filtro, Pageable pageable) throws Exception;
}
