package com.utn.sprint3.services;

import com.utn.sprint3.entidades.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnidadMedidaServices extends BaseServices<UnidadMedida,Long> {

    List<UnidadMedida> search(String filtro) throws Exception;
    Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception;
}
