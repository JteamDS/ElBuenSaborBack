package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleFactura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleFacturaServices extends BaseServices<DetalleFactura,Long> {

    List<DetalleFactura> search(Integer filtro) throws Exception;
    Page<DetalleFactura> search(Integer filtro, Pageable pageable) throws Exception;
}
