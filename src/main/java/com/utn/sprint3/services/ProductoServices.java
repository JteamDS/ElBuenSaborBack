package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoProducto;
import com.utn.sprint3.entidades.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoServices extends BaseServices<Producto, Long>{

    List<Producto> search(String filtro) throws Exception;
    Producto crearProducto(DtoProducto dtoProducto) throws Exception;
    Page<Producto> search(String filtro, Pageable pageable) throws Exception;
    String verMasVendidos() throws Exception;
}
