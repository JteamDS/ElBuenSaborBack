package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoCliente;
import com.utn.sprint3.Dto.DtoDomicilio;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.ClienteRepository;
import com.utn.sprint3.repositorios.DomicilioRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicesImpl extends BaseServicesImpl<Cliente,Long> implements ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;

    public ClienteServicesImpl(BaseRepository<Cliente, Long> baseRepository,
                               ClienteRepository clienteRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.search(filtro);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.search(filtro, pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public DtoCliente verDatos(Long id) throws Exception {
        try {
            Cliente cliente = clienteRepository.buscarPorId(id);
            DtoCliente dtoCliente = new DtoCliente();

            dtoCliente.setUsername(cliente.getUsuario().getUsername());
            dtoCliente.setPassword(cliente.getUsuario().getPassword());
            dtoCliente.setNombre(cliente.getNombre());
            dtoCliente.setApellido(cliente.getApellido());
            dtoCliente.setEmail(cliente.getEmail());
            dtoCliente.setTelefono(cliente.getTelefono());
            dtoCliente.setDomicilio(cliente.getDomicilios());
            dtoCliente.setIdCliente(cliente.getId());
            return dtoCliente;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public Cliente modificarDatos(DtoCliente dtoCliente) throws Exception {
        try {
            Cliente cliente = clienteRepository.buscarPorId(dtoCliente.getIdCliente());
            if(dtoCliente.getEmail()!=null){
                cliente.setEmail(dtoCliente.getEmail());
            }
            if(dtoCliente.getTelefono()!=null){
                cliente.setTelefono(dtoCliente.getTelefono());
            }

            if (dtoCliente.getPassword()!=null){
                cliente.getUsuario().setPassword(dtoCliente.getPassword());
            }
            clienteRepository.save(cliente);
            return cliente;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Cliente agregarDomicilio(DtoDomicilio dto) throws Exception {
        try {
            Cliente cliente = clienteRepository.buscarPorId(dto.getIdCliente());
            List<Domicilio> domiciliosCliente = cliente.getDomicilios();
            Domicilio domicilio = new Domicilio();

            domicilio.setCalle(dto.getCalle());
            domicilio.setNumero(dto.getNumero());
            domicilio.setCodigoPostal(dto.getCodigoPostal());
            domicilio.setLocalidad(dto.getLocalidad());
            domiciliosCliente.add(domicilio);
            cliente.setDomicilios(domiciliosCliente);
            clienteRepository.save(cliente);
            return cliente;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cliente eliminarDomicilio(Long idCliente, Long idDomicilio) throws Exception {
        try {
            Cliente cliente = clienteRepository.buscarPorId(idCliente);
            Domicilio domicilio = domicilioRepository.getById(idDomicilio);
            cliente.getDomicilios().remove(domicilio);
            domicilioRepository.deleteById(idDomicilio);
            return cliente;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Pedido> verPedidos(Long id) throws Exception {
        try {
            List<Pedido> pedidos = clienteRepository.buscarPorId(id).getPedidos();
            return pedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}

