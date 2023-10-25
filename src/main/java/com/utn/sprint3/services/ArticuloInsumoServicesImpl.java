package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticuloInsumoServicesImpl extends BaseServicesImpl<ArticuloInsumo,Long> implements ArticuloInsumoServices {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServicesImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {

        super(baseRepository);
    }


    @Override
    public List<ArticuloInsumo> search(String filtro) throws Exception {
        try{
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.searchNativo(filtro);
            return articuloInsumos;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<ArticuloInsumo> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<ArticuloInsumo> articulosInsumos= articuloInsumoRepository.searchNativo(filtro, pageable);
            return articulosInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
