package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido,Long> {

    List<DetallePedido> findByCantidadContaining(Integer cantidad);

    @Query(value = "SELECT dp FROM DetallePedido dp WHERE dp.cantidad LIKE %:filtro%")
    List<DetallePedido> search(@Param("filtro") Integer filtro);

    @Query(
            value = "SELECT * FROM detallePedido WHERE detallePedido.cantidad LIKE %:filtro%",
            nativeQuery = true
    )
    List<DetallePedido> searchNativo(@Param("filtro") Integer filtro);
    Page<DetallePedido> findByCantidadContaining(Integer cantidad, Pageable pageable);

    @Query(value = "SELECT dp FROM DetallePedido dp WHERE dp.cantidad LIKE %:filtro%")
    Page<DetallePedido> search(@Param("filtro") Integer filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM detallePedido WHERE detallePedido.cantidad LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM detallePedido",
            nativeQuery = true
    )
    Page<DetallePedido> searchNativo(@Param("filtro") Integer filtro, Pageable pageable);
}
