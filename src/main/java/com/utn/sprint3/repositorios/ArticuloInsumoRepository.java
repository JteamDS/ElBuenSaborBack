package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long>{

    List<ArticuloInsumo> findByDenominacionContaining(String denominacion);

    @Query(value = "SELECT ai FROM ArticuloInsumo ai WHERE ai.denominacion LIKE %:filtro%")
    List<ArticuloInsumo> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM articuloInsumo WHERE articuloInsumo.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloInsumo> searchNativo(@Param("filtro") String filtro);
    Page<ArticuloInsumo> findByDenominacionContaining(String denominacion, Pageable pageable);

    @Query(value = "SELECT ai FROM ArticuloInsumo ai WHERE ai.denominacion LIKE %:filtro%")
    Page<ArticuloInsumo> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM articuloInsumo WHERE articuloInsumo.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articuloInsumo",
            nativeQuery = true
    )
    Page<ArticuloInsumo> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
