package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.ClienteRepository;
import com.utn.sprint3.repositorios.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServicesImpl extends BaseServicesImpl<DetalleFactura,Long> implements DetalleFacturaServices {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServicesImpl(BaseRepository<DetalleFactura, Long> baseRepository) {
        super(baseRepository);

    }

    @Override
    public List<DetalleFactura> search(Integer filtro) throws Exception {
        try{
            List<DetalleFactura> detalleFacturas = detalleFacturaRepository.searchNativo(filtro);
            return detalleFacturas;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<DetalleFactura> search(Integer filtro, Pageable pageable) throws Exception {
        try{
            Page<DetalleFactura> detalleFacturas= detalleFacturaRepository.searchNativo(filtro, pageable);
            return detalleFacturas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
