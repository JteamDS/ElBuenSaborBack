package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long> {

    List<Domicilio> findByCodigoPostalContaining(Integer codigoPostal);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.codigoPostal LIKE %:filtro%")
    List<Domicilio> search(@Param("filtro") Integer filtro);

    @Query(
            value = "SELECT * FROM domicilio WHERE domicilio.codigoPostal LIKE %:filtro%",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(@Param("filtro") Integer filtro);

    Page<Domicilio> findByCodigoPostalContaining(Integer codigoPostal, Pageable pageable);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.codigoPostal LIKE %:filtro%")
    Page<Domicilio> search(@Param("filtro") Integer filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM domicilio WHERE domicilio.codigoPostal LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM domicilio",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(@Param("filtro") Integer filtro, Pageable pageable);
}
