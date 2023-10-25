package com.utn.sprint3.services;

import com.utn.sprint3.entidades.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloServices extends BaseServices<RubroArticulo,Long> {

    List<RubroArticulo> search(String filtro) throws Exception;
    Page<RubroArticulo> search(String filtro, Pageable pageable) throws Exception;
}
