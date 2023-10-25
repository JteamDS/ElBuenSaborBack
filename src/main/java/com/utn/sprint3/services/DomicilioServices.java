package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioServices extends BaseServices<Domicilio,Long> {

    List<Domicilio> search(Integer filtro) throws Exception;
    Page<Domicilio> search(Integer filtro, Pageable pageable) throws Exception;
}
