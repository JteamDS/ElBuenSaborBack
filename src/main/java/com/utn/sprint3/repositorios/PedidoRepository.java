package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {

    List<Pedido> findByFechaPedidoContaining(Date fechaPedido);

    @Query(value = "SELECT p FROM Pedido p WHERE p.fechaPedido = :filtro")
    List<Pedido> search(@Param("filtro") Date filtro);

    @Query(
            value = "SELECT * FROM pedido WHERE pedido.fechaPedido = :filtro ",
            nativeQuery = true
    )
    List<Pedido> searchNativo(@Param("filtro") Date filtro);

    Page<Pedido> findByFechaPedidoContaining(Date fechaPedido, Pageable pageable);

    @Query(value = "SELECT p FROM Pedido p WHERE p.fechaPedido = :filtro")
    Page<Pedido> search(@Param("filtro") Date filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM pedido WHERE pedido.fechaPedido = :filtro",
            countQuery = "SELECT count(*) FROM pedido",
            nativeQuery = true
    )
    Page<Pedido> searchNativo(@Param("filtro") Date filtro, Pageable pageable);

}

