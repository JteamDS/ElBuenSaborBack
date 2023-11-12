package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enumeraciones.EstadoPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {

    @Query(value = "SELECT p FROM Pedido p WHERE p.fechaPedido = :filtro")
    List<Pedido> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Pedido p WHERE p.estado = :estado")
    List<Pedido> buscarEstado(@Param("estado")EstadoPedido estado);

    @Query(value = "SELECT p FROM Pedido p WHERE p.id = :id")
    Pedido buscarId(@Param("id")Long id);

    @Query(value = "SELECT p FROM Pedido p WHERE p.fechaPedido = :filtro")
    Page<Pedido> search(@Param("filtro") String filtro, Pageable pageable);


}

