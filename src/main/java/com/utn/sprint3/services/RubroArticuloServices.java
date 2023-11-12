package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoEmpleado;
import com.utn.sprint3.Dto.DtoRubro;
import com.utn.sprint3.entidades.Empleado;
import com.utn.sprint3.entidades.Producto;
import com.utn.sprint3.entidades.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloServices extends BaseServices<RubroArticulo,Long> {

    List<Producto> buscarPorCategoria(String nombre) throws Exception;
    RubroArticulo modificarRubro(DtoRubro dtoRubro) throws Exception;
}
