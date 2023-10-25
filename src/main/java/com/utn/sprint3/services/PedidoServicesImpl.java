package com.utn.sprint3.services;


import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicesImpl extends BaseServicesImpl<Pedido,Long> implements PedidoServices {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServicesImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> search(java.util.Date filtro) throws Exception {
        try{
            List<Pedido> pedidos = pedidoRepository.searchNativo(filtro);
            return pedidos;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Pedido> search(java.util.Date filtro, Pageable pageable) throws Exception {
        try{
            Page<Pedido> pedidos = pedidoRepository.searchNativo(filtro,pageable);
            return pedidos;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
