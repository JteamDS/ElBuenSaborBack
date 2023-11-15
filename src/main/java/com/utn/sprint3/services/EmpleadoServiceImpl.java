package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoEmpleado;
import com.utn.sprint3.entidades.Empleado;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.jwt.JwtService;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.EmpleadoRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends BaseServicesImpl<Empleado,Long> implements EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    public EmpleadoServiceImpl(BaseRepository<Empleado,Long> baseRepository,
                               EmpleadoRepository empleadoRepository, UsuarioRepository usuarioRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        super(baseRepository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Empleado crearEmpleado(DtoEmpleado dtoEmpleado) throws Exception {
        try {
            Empleado empleado = new Empleado();
            Usuario usuario = new Usuario();

            empleado.setNombre(dtoEmpleado.getNombre());
            empleado.setApellido(dtoEmpleado.getApellido());
            empleado.setTelefono(dtoEmpleado.getTelefono());
            empleado.setEmail(dtoEmpleado.getEmail());
            usuario.setUsername(dtoEmpleado.getUsername());
            usuario.setPassword(passwordEncoder.encode(dtoEmpleado.getPassword()));
            usuario.setRol(dtoEmpleado.getRol());
            usuarioRepository.save(usuario);
            empleado.setUsuario(usuario);
            empleadoRepository.save(empleado);


            return empleado;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DtoEmpleado verDatos(Long id) throws Exception {
        try {
            DtoEmpleado dtoEmpleado = new DtoEmpleado();
            Empleado empleado = empleadoRepository.buscarPorId(id);

            dtoEmpleado.setIdEmpleado(empleado.getId());
            dtoEmpleado.setNombre(empleado.getNombre());
            dtoEmpleado.setApellido(empleado.getApellido());
            dtoEmpleado.setTelefono(empleado.getTelefono());
            dtoEmpleado.setEmail(empleado.getEmail());
            dtoEmpleado.setRol(empleado.getUsuario().getRol());
            dtoEmpleado.setUsername(empleado.getUsuario().getUsername());
            dtoEmpleado.setPassword(empleado.getUsuario().getPassword());

            return dtoEmpleado;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Empleado modificarDatos(DtoEmpleado dtoEmpleado) throws Exception {
        try {
            Empleado empleado = empleadoRepository.buscarPorId(dtoEmpleado.getIdEmpleado());

            if(dtoEmpleado.getEmail()!=null){
                empleado.setEmail(dtoEmpleado.getEmail());
            }
            if(dtoEmpleado.getTelefono()!=null){
                empleado.setTelefono(dtoEmpleado.getTelefono());
            }

            if (dtoEmpleado.getPassword()!=null){
                empleado.getUsuario().setPassword(dtoEmpleado.getPassword());
            }
            empleadoRepository.save(empleado);
            return empleado;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
