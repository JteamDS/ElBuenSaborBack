package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long>{

    List<ArticuloManufacturado> findByDenominacionContaining(String denominacion);

    @Query(value = "SELECT am FROM ArticuloManufacturado am WHERE am.denominacion LIKE %:filtro%")
    List<ArticuloManufacturado> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM articuloManufacturado WHERE articuloManufacturado.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro);
    Page<ArticuloManufacturado> findByDenominacionContaining(String denominacion, Pageable pageable);

    @Query(value = "SELECT am FROM ArticuloManufacturado am WHERE am.denominacion LIKE %:filtro%")
    Page<ArticuloManufacturado> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM articuloManufacturado WHERE articuloManufacturado.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articuloManufacturado",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}

