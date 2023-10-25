package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioServices extends BaseServices<Usuario,Long> {

    List<Usuario> search(String filtro) throws Exception;
    Page<Usuario> search(String filtro, Pageable pageable) throws Exception;
}
