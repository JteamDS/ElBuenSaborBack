package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoProducto;
import com.utn.sprint3.entidades.*;
import com.utn.sprint3.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicesImpl extends BaseServicesImpl<Producto,Long> implements ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;
    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;
    @Autowired
    PedidoRepository pedidoRepository;

    public ProductoServicesImpl(BaseRepository<Producto, Long> baseRepository,
                                ProductoRepository productoRepository,UnidadMedidaRepository unidadMedidaRepository,
                                PedidoRepository pedidoRepository) {

        super(baseRepository);
    }


    @Override
    public List<Producto> search(String nombre) throws Exception {
        try{
            List<Producto> productos = productoRepository.search(nombre);
            return productos;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Producto crearProducto(DtoProducto dtoProducto) throws Exception {
        try {
            Producto producto = new Producto();
            RubroArticulo rubroArticulo = rubroArticuloRepository.buscarPorId(dtoProducto.getIdRubro());

            producto.setNombre(dtoProducto.getNombre());
            producto.setCosto(dtoProducto.getCosto());
            producto.setDescripcion(dtoProducto.getDescripcion());
            producto.setStockActual(dtoProducto.getStockActual());
            producto.setStockMinimo(dtoProducto.getStockMinimo());
            producto.setPrecioVenta(dtoProducto.getPrecioVenta());
            if (dtoProducto.getIdUnidadMedida()!=null){
                UnidadMedida unidadMedida = unidadMedidaRepository.buscarPorId(dtoProducto.getIdUnidadMedida());
                producto.setUnidadMedida(unidadMedida);
            }
            productoRepository.save(producto);
            List<Producto> productos = rubroArticulo.getProductos();
            productos.add(producto);
            rubroArticulo.setProductos(productos);
            rubroArticuloRepository.save(rubroArticulo);
            return producto;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Producto> search(String nombre, Pageable pageable) throws Exception {
        try{
            Page<Producto> articulosInsumos= productoRepository.search(nombre, pageable);
            return articulosInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String verMasVendidos() throws Exception {
        try {
            List<Producto> productos = productoRepository.findAll();
            List<Pedido> pedidos = pedidoRepository.findAll();
            String producto1 = "";
            int contador1 = 0;
            String producto2 = "";
            int contador2 = 0;
            String producto3 = "";
            int contador3 = 0;
            String producto4 = "";
            int contador4 = 0;

            for (Producto producto : productos){
                int contador = 0;
                for (Pedido pedido : pedidos){
                    for (DetallePedido detallePedido : pedido.getDetallePedidos()){
                        if (detallePedido.getProducto()==producto){
                            contador = contador + detallePedido.getCantidad();
                        }
                    }
                }
                if (contador>=contador1){
                    String producAux1 = producto1;
                    String producAux2 = producto2;
                    String producAux3 = producto3;
                    int contAux1 = contador1;
                    int contAux2 = contador2;
                    int contAux3 = contador3;

                    producto1 = producto.getNombre();
                    contador1 = contador;
                    producto2 = producAux1;
                    contador2 = contAux1;
                    producto3 = producAux2;
                    contador3 = contAux2;
                    producto4 = producAux3;
                    contador4 = contAux3;
                } else{
                    if (contador>=contador2){
                        String producAux1 = producto2;
                        String producAux2 = producto3;
                        int contAux1 = contador2;
                        int contAux2 = contador3;

                        producto2 = producto.getNombre();
                        contador2 = contador;
                        producto3 = producAux1;
                        contador3 = contAux1;
                        producto4 = producAux2;
                        contador4 = contAux2;
                    } else {
                        if (contador>=contador3){
                            String producAux = producto3;
                            int contAux = contador3;

                            producto3=producto.getNombre();
                            contador3=contador;
                            producto4=producAux;
                            contador4=contAux;
                        } else {
                            if (contador>=contador4){

                                producto4=producto.getNombre();
                                contador4=contador;
                            }
                        }
                    }
                }
            }
            return "---------------RANKING PRODUCTOS MAS VENDIDOS------------------\n" +
                    "1- "+ producto1 +"  Cantidad Vendida: "+ contador1 +"\n" +
                    "2- "+ producto2 +"  Cantidad Vendida: "+ contador2 +"\n" +
                    "3- "+ producto3 +"  Cantidad Vendida: "+ contador3 +"\n" +
                    "4- "+ producto4 +"  Cantidad Vendida: "+ contador4 +"\n";
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
