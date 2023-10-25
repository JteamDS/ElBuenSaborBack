package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura,Long> {

    List<Factura> findByMpPaymentTypeContaining(String mpPaymentType);

    @Query(value = "SELECT f FROM Factura f WHERE f.mpPaymentType LIKE %:filtro%")
    List<Factura> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM factura WHERE factura.mpPaymentType LIKE %:filtro%",
            nativeQuery = true
    )
    List<Factura> searchNativo(@Param("filtro") String filtro);
    Page<Factura> findByMpPaymentTypeContaining(String mpPaymentType, Pageable pageable);

    @Query(value = "SELECT f FROM Factura f WHERE f.mpPaymentType LIKE %:filtro%")
    Page<Factura> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM factura WHERE factura.mpPaymentType LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM factura",
            nativeQuery = true
    )
    Page<Factura> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
