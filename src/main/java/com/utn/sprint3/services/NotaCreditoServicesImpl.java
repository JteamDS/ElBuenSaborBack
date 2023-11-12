package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoNota;
import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.DetalleNota;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.NotaCredito;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.FacturaRepository;
import com.utn.sprint3.repositorios.NotaCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaCreditoServicesImpl extends BaseServicesImpl<NotaCredito,Long> implements NotaCreditoServices {

    @Autowired
    private NotaCreditoRepository notaCreditoRepository;
    @Autowired
    private FacturaRepository facturaRepository;

    public NotaCreditoServicesImpl(BaseRepository<NotaCredito, Long> baseRepository,
                                   NotaCreditoRepository notaCreditoRepository,FacturaRepository facturaRepository) {
        super(baseRepository);
    }

    @Override
    public NotaCredito anularFactura(DtoNota dtoNota) throws Exception {
        try {
            Factura factura = facturaRepository.buscarId(dtoNota.getIdFactura());
            NotaCredito notaCredito = new NotaCredito();

            notaCredito.setFactura(factura);
            notaCredito.setTotalDevolucion(factura.getTotalVenta());
            notaCredito.setObservacion(dtoNota.getObservacion());

            List<DetalleNota> detalleNotas = new ArrayList<>();
            List<DetalleFactura> detalleFacturas = factura.getDetalleFacturas();
            for (DetalleFactura detalleFactura : detalleFacturas){
                DetalleNota detalleNota = new DetalleNota();
                detalleNota.setCantidad(detalleFactura.getCantidad());
                detalleNota.setSubtotal(detalleFactura.getSubtotal());
                detalleNota.setProducto(detalleFactura.getProducto());
                detalleFactura.getProducto().setStockActual(detalleFactura.getProducto().getStockActual()+detalleFactura.getCantidad());
                detalleNotas.add(detalleNota);
            }
            notaCredito.setDetalleNotas(detalleNotas);

            notaCreditoRepository.save(notaCredito);
            return notaCredito;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
