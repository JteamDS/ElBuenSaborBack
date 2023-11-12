package com.utn.sprint3.services;

import com.utn.sprint3.entidades.UnidadMedida;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServicesImpl extends BaseServicesImpl<UnidadMedida,Long> implements UnidadMedidaServices {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServicesImpl(BaseRepository<UnidadMedida, Long> baseRepository) {
        super(baseRepository);

    }

    @Override
    public List<UnidadMedida> search(String filtro) throws Exception {
        try{
            List<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro);
            return unidadMedidas;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }
    @Override
    public Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<UnidadMedida> unidadMedidas= unidadMedidaRepository.search(filtro, pageable);
            return unidadMedidas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
