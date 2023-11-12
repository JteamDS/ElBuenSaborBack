package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoEmpleado;
import com.utn.sprint3.entidades.Empleado;

public interface EmpleadoService extends BaseServices<Empleado, Long>{
    public Empleado crearEmpleado(DtoEmpleado dtoEmpleado) throws Exception;
    public DtoEmpleado verDatos(Long id) throws Exception;
    public Empleado modificarDatos(DtoEmpleado dtoEmpleado) throws Exception;
}
