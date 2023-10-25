package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicesImpl extends BaseServicesImpl<Cliente,Long> implements ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServicesImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.searchNativo(filtro);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.searchNativo(filtro, pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

