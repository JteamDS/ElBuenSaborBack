package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetalleFacturaRepository;
import com.utn.sprint3.repositorios.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServicesImpl extends BaseServicesImpl<DetallePedido,Long> implements DetallePedidoServices {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServicesImpl(BaseRepository<DetallePedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetallePedido> search(Integer filtro) throws Exception {
        try{
            List<DetallePedido> detallePedidos = detallePedidoRepository.searchNativo(filtro);
            return detallePedidos;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<DetallePedido> search(Integer filtro, Pageable pageable) throws Exception {
        try{
            Page<DetallePedido> detallePedidos= detallePedidoRepository.searchNativo(filtro, pageable);
            return detallePedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
