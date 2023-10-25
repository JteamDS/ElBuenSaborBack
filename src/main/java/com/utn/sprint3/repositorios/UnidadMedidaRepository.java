package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida,Long> {

    List<UnidadMedida> findByDenominacionContaining(String denominacion);

    @Query(value = "SELECT um FROM UnidadMedida um WHERE um.denominacion LIKE %:filtro%")
    List<UnidadMedida> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM unidadMedida WHERE unidadMedida.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<UnidadMedida> searchNativo(@Param("filtro") String filtro);
    Page<UnidadMedida> findByDenominacionContaining(String denominacion, Pageable pageable);

    @Query(value = "SELECT um FROM UnidadMedida um WHERE um.denominacion LIKE %:filtro%")
    Page<UnidadMedida> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM unidadMedida WHERE unidadMedida.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM unidadMedida",
            nativeQuery = true
    )
    Page<UnidadMedida> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
