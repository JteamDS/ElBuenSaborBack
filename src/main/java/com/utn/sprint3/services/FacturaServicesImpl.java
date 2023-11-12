package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoFactura;
import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enumeraciones.EstadoFactura;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.FacturaRepository;
import com.utn.sprint3.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaServicesImpl extends BaseServicesImpl<Factura,Long> implements FacturaServices {

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    PedidoRepository pedidoRepository;

    public FacturaServicesImpl(BaseRepository<Factura, Long> baseRepository,
                               FacturaRepository facturaRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
    }

}
