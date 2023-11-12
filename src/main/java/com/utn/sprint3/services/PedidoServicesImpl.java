package com.utn.sprint3.services;


import com.utn.sprint3.Dto.DtoFactura;
import com.utn.sprint3.Dto.DtoPedido;
import com.utn.sprint3.Dto.DtoPedidoProducto;
import com.utn.sprint3.entidades.*;
import com.utn.sprint3.enumeraciones.EstadoFactura;
import com.utn.sprint3.enumeraciones.EstadoPedido;
import com.utn.sprint3.enumeraciones.FormaPago;
import com.utn.sprint3.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServicesImpl extends BaseServicesImpl<Pedido,Long> implements PedidoServices {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private FacturaRepository facturaRepository;

    public PedidoServicesImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository,
                              ClienteRepository clienteRepository, DomicilioRepository domicilioRepository,
                              ProductoRepository productoRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> search(String filtro) throws Exception {
        try{
            List<Pedido> pedidos = pedidoRepository.search(filtro);
            return pedidos;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Pedido> pedidos = pedidoRepository.search(filtro,pageable);
            return pedidos;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Pedido crearPedido(DtoPedido dtoPedido) throws Exception {
        try {
            Pedido pedido = new Pedido();
            Cliente cliente = clienteRepository.buscarPorId(dtoPedido.getIdCliente());

            pedido.setFechaPedido(dtoPedido.getFechaPedido());
            pedido.setFormaPago(dtoPedido.getFormaPago());
            pedido.setTipoEnvio(dtoPedido.getTipoEnvio());
            pedido.setEstado(EstadoPedido.PENDIENTE_PAGO);
            pedido.setDomicilioEntrega(domicilioRepository.getById(dtoPedido.getIdDomicilio()));

            List<DtoPedidoProducto> dtoPedidoProductos = dtoPedido.getProductos();
            List<DetallePedido> detallePedidos = new ArrayList<>();
            Float total = 0f;
            for (DtoPedidoProducto dtoPedidoProducto : dtoPedidoProductos){
                DetallePedido detallePedido = new DetallePedido();
                Producto producto = productoRepository.buscarPorNombre(dtoPedidoProducto.getNombre());
                detallePedido.setCantidad(dtoPedidoProducto.getCantidad());
                detallePedido.setProducto(producto);
                detallePedido.setSubtotal(detallePedido.getProducto().getPrecioVenta()*detallePedido.getCantidad());
                detallePedidos.add(detallePedido);
                producto.setStockActual(producto.getStockActual()-detallePedido.getCantidad());
                total=total+detallePedido.getSubtotal();
            }
            pedido.setDetallePedidos(detallePedidos);
            pedido.setTotal(total);
            List<Pedido> pedidos = cliente.getPedidos();
            pedidos.add(pedido);

            pedidoRepository.save(pedido);
            return pedido;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Pedido> buscarEstado(EstadoPedido estadoPedido) throws Exception {
        try {
            List<Pedido> pedidos=pedidoRepository.buscarEstado(estadoPedido);
            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Pedido cambiarEstado(Long id, EstadoPedido estado) throws Exception {
        try {
            Pedido pedido = pedidoRepository.buscarId(id);
            pedido.setEstado(estado);
            pedidoRepository.save(pedido);
            return pedido;
        } catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
    @Override
    public Factura crearFactura(DtoFactura dtoFactura) throws Exception {
        try {
            Pedido pedido = pedidoRepository.buscarId(dtoFactura.getIdPedido());
            Factura factura = new Factura();

            factura.setEstadoFactura(EstadoFactura.EMITIDA);
            factura.setTotalVenta(pedido.getTotal());
            factura.setFormaPago(pedido.getFormaPago());
            factura.setFechaFacturacion(dtoFactura.getFechaFacturacion());

            List<DetalleFactura> detalleFacturas = new ArrayList<>();
            List<DetallePedido> detallePedidos = pedido.getDetallePedidos();
            for (DetallePedido detallePedido : detallePedidos){
                DetalleFactura detalleFactura = new DetalleFactura();
                detalleFactura.setCantidad(detallePedido.getCantidad());
                detalleFactura.setProducto(detallePedido.getProducto());
                detalleFactura.setSubtotal(detallePedido.getSubtotal());
                detalleFacturas.add(detalleFactura);
            }
            factura.setDetalleFacturas(detalleFacturas);
            facturaRepository.save(factura);
            pedido.setFactura(factura);

            pedidoRepository.save(pedido);
            return factura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
