package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFactura,Long>{

    List<DetalleFactura> findByCantidadContaining(Integer cantidad);

    @Query(value = "SELECT df FROM DetalleFactura df WHERE df.cantidad LIKE %:filtro%")
    List<DetalleFactura> search(@Param("filtro") Integer filtro);

    @Query(
            value = "SELECT * FROM detalleFactura WHERE detalleFactura.cantidad LIKE %:filtro%",
            nativeQuery = true
    )
    List<DetalleFactura> searchNativo(@Param("filtro") Integer filtro);
    Page<DetalleFactura> findByCantidadContaining(Integer cantidad, Pageable pageable);

    @Query(value = "SELECT df FROM DetalleFactura df WHERE df.cantidad LIKE %:filtro%")
    Page<DetalleFactura> search(@Param("filtro") Integer filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM detalleFactura WHERE detalleFactura.cantidad LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM detalleFactura",
            nativeQuery = true
    )
    Page<DetalleFactura> searchNativo(@Param("filtro") Integer filtro, Pageable pageable);
}
