package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.PedidoRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloServicesImpl extends BaseServicesImpl<RubroArticulo,Long> implements RubroArticuloServices {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServicesImpl(BaseRepository<RubroArticulo, Long> baseRepository) {
        super(baseRepository);

    }

    @Override
    public List<RubroArticulo> search(String filtro) throws Exception {
        try{
            List<RubroArticulo> rubroArticulos = rubroArticuloRepository.searchNativo(filtro);
            return rubroArticulos;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<RubroArticulo> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<RubroArticulo> rubroArticulos= rubroArticuloRepository.searchNativo(filtro, pageable);
            return rubroArticulos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
