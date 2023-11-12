package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoFactura;
import com.utn.sprint3.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacturaServices extends BaseServices<Factura,Long> {

}
