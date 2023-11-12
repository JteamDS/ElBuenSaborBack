package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoProducto;
import com.utn.sprint3.entidades.Producto;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.entidades.UnidadMedida;
import com.utn.sprint3.repositorios.ProductoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
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

    public ProductoServicesImpl(BaseRepository<Producto, Long> baseRepository,
                                ProductoRepository productoRepository,UnidadMedidaRepository unidadMedidaRepository) {

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


}
