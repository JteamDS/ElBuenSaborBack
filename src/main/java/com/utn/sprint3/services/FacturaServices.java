package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacturaServices extends BaseServices<Factura,Long> {

    List<Factura> search(String filtro) throws Exception;
    Page<Factura> search(String filtro, Pageable pageable) throws Exception;
}
