package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteServices extends BaseServices<Cliente, Long> {

    List<Cliente> search(String filtro) throws Exception;
    Page<Cliente> search(String filtro, Pageable pageable) throws Exception;
}
