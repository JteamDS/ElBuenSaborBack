package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long> {

    List<Usuario> findByUsernameContaining(String username);

    @Query(value = "SELECT u FROM Usuario u WHERE u.username LIKE %:filtro%")
    List<Usuario> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro%",
            nativeQuery = true
    )
    List<Usuario> searchNativo(@Param("filtro") String filtro);

    Page<Usuario> findByUsernameContaining(String username, Pageable pageable);

    @Query(value = "SELECT u FROM Usuario u WHERE u.username LIKE %:filtro%")
    Page<Usuario> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM usuario",
            nativeQuery = true
    )
    Page<Usuario> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}