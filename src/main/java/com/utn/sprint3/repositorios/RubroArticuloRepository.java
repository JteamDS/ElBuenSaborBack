package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloRepository extends BaseRepository<RubroArticulo,Long> {

    List<RubroArticulo> findByDenominacionContaining(String denominacion);

    @Query(value = "SELECT ra FROM RubroArticulo ra WHERE ra.denominacion LIKE %:filtro%")
    List<RubroArticulo> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM rubroArticulo WHERE rubroArticulo.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<RubroArticulo> searchNativo(@Param("filtro") String filtro);
    Page<RubroArticulo> findByDenominacionContaining(String denominacion, Pageable pageable);

    @Query(value = "SELECT ra FROM RubroArticulo ra WHERE ra.denominacion LIKE %:filtro%")
    Page<Usuario> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM rubroArticulo WHERE rubroArticulo.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM rubroArticulo",
            nativeQuery = true
    )
    Page<RubroArticulo> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
