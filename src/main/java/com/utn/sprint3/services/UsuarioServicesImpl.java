package com.utn.sprint3.services;

import com.utn.sprint3.entidades.UnidadMedida;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicesImpl extends BaseServicesImpl<Usuario,Long> implements UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServicesImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Usuario> search(String filtro) throws Exception {
        try{
            List<Usuario> usuarios = usuarioRepository.search(filtro);
            return usuarios;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Usuario> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Usuario> usuarios= usuarioRepository.search(filtro, pageable);
            return usuarios;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
