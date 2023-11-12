package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoCliente;
import com.utn.sprint3.Dto.DtoDomicilio;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteServices extends BaseServices<Cliente, Long> {

    List<Cliente> search(String filtro) throws Exception;
    Page<Cliente> search(String filtro, Pageable pageable) throws Exception;
    DtoCliente verDatos(Long id) throws Exception;
    Cliente modificarDatos(DtoCliente dtoCliente) throws Exception;
    Cliente agregarDomicilio(DtoDomicilio dto) throws Exception;
    Cliente eliminarDomicilio(Long idCliente, Long idDomicilio) throws Exception;
    List<Pedido> verPedidos(Long id) throws Exception;
}
