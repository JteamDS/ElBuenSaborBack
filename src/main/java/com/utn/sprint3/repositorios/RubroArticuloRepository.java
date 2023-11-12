package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
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

    @Query("SELECT ra FROM RubroArticulo ra WHERE ra.nombre = :nombre")
    RubroArticulo buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT ra FROM RubroArticulo ra WHERE ra.id = :id")
    RubroArticulo buscarPorId(@Param("id") Long id);
}
