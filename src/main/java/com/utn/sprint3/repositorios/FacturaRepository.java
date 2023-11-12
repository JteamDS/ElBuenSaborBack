package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enumeraciones.EstadoPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura,Long> {

    @Query(value = "SELECT f FROM Factura f WHERE f.id = :id")
    Factura buscarId(@Param("id") Long id);
}
