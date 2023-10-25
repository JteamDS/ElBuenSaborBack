package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.repositorios.ArticuloManufacturadoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoServicesImpl extends BaseServicesImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoServices {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServicesImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);

    }

    @Override
    public List<ArticuloManufacturado> search(String filtro) throws Exception {
        try{
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.searchNativo(filtro);
            return articuloManufacturados;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<ArticuloManufacturado> articuloManufacturados= articuloManufacturadoRepository.searchNativo(filtro, pageable);
            return articuloManufacturados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
