package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto,Long>{

    @Query(value = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    List<Producto> search(@Param("nombre") String nombre);

    @Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
    Producto buscarPorNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    Page<Producto> search(@Param("nombre") String nombre, Pageable pageable);

}
