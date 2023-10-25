package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetallePedidoRepository;
import com.utn.sprint3.repositorios.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServicesImpl extends BaseServicesImpl<Domicilio,Long> implements DomicilioServices {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServicesImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);

    }

    @Override
    public List<Domicilio> search(Integer filtro) throws Exception {
        try{
            List<Domicilio> domicilios = domicilioRepository.searchNativo(filtro);
            return domicilios;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Domicilio> search(Integer filtro, Pageable pageable) throws Exception {
        try{
            Page<Domicilio> domicilios= domicilioRepository.searchNativo(filtro, pageable);
            return domicilios;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
