package com.utn.sprint3.services;

import com.utn.sprint3.Dto.AuthResponse;
import com.utn.sprint3.Dto.DtoCliente;
import com.utn.sprint3.Dto.DtoLogin;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.enumeraciones.Rol;
import com.utn.sprint3.jwt.JwtService;
import com.utn.sprint3.repositorios.ClienteRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.stream.DoubleStream.builder;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ClienteRepository clienteRepository;

    public AuthResponse login(DtoLogin dtoLogin) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoLogin.getUsername(), dtoLogin.getPassword()));
            UserDetails user=userRepository.findByUsername(dtoLogin.getUsername()).orElseThrow();
            String token=jwtService.getToken(user);
            return AuthResponse.builder()
                    .token(token)
                    .build();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    public AuthResponse registerAdmin(DtoLogin dtoLogin) throws Exception{
        Usuario usuario = new Usuario();
        usuario.setUsername(dtoLogin.getUsername());
        usuario.setPassword(passwordEncoder.encode(dtoLogin.getPassword()));
        usuario.setRol(Rol.ADMINISTRADOR);
        userRepository.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }

    public AuthResponse register(DtoCliente dtoCliente) throws Exception{
        try {
            Cliente cliente = new Cliente();
            cliente.setNombre(dtoCliente.getNombre());
            cliente.setApellido(dtoCliente.getApellido());
            cliente.setEmail(dtoCliente.getEmail());
            cliente.setTelefono(dtoCliente.getTelefono());
            Usuario usuario = new Usuario();
            usuario.setUsername(dtoCliente.getUsername());
            usuario.setPassword(passwordEncoder.encode(dtoCliente.getPassword()));
            usuario.setRol(Rol.CLIENTE);
            userRepository.save(usuario);
            cliente.setUsuario(usuario);
            clienteRepository.save(cliente);

            return AuthResponse.builder()
                    .token(jwtService.getToken(usuario))
                    .build();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
