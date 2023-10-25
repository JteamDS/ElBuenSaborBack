package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloManufacturadoServices extends BaseServices<ArticuloManufacturado, Long> {

    List<ArticuloManufacturado> search(String filtro) throws Exception;
    Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception;

}
