package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetallePedidoServices extends BaseServices<DetallePedido,Long> {

    List<DetallePedido> search(Integer filtro) throws Exception;
    Page<DetallePedido> search(Integer filtro, Pageable pageable) throws Exception;
}
