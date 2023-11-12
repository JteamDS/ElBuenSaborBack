package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoRubro;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.entidades.Producto;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.PedidoRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloServicesImpl extends BaseServicesImpl<RubroArticulo,Long> implements RubroArticuloServices {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServicesImpl(BaseRepository<RubroArticulo, Long> baseRepository) {
        super(baseRepository);

    }

    @Override
    public List<Producto> buscarPorCategoria(String nombre) throws Exception {
        try {
            List<Producto> productos = rubroArticuloRepository.buscarPorNombre(nombre).getProductos();
            return productos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public RubroArticulo modificarRubro(DtoRubro dtoRubro) throws Exception {
        try {
            RubroArticulo rubroArticulo = rubroArticuloRepository.getById(dtoRubro.getIdRubro());

            if (dtoRubro.getNombre()!=null){
                rubroArticulo.setNombre(dtoRubro.getNombre());
            }
            if (dtoRubro.getEstadoRubro()!=null){
                rubroArticulo.setEstadoRubro(dtoRubro.getEstadoRubro());
            }
            rubroArticuloRepository.save(rubroArticulo);
            return rubroArticulo;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
