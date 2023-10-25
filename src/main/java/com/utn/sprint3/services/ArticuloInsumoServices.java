package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoServices extends BaseServices<ArticuloInsumo, Long>{

    List<ArticuloInsumo> search(String filtro) throws Exception;

    Page<ArticuloInsumo> search(String filtro, Pageable pageable) throws Exception;
}
