package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoCliente;
import com.utn.sprint3.Dto.DtoDomicilio;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.repositorios.*;
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
    @Autowired
    private PedidoRepository pedidoRepository;

    public ClienteServicesImpl(BaseRepository<Cliente, Long> baseRepository,
                               ClienteRepository clienteRepository, DomicilioRepository domicilioRepository,
                               PedidoRepository pedidoRepository) {
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

    @Override
    public String clienteMasPedidos() throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findAll();
            String cliente1 = "";
            int contador1 = 0;
            String cliente2 = "";
            int contador2 = 0;
            String cliente3 = "";
            int contador3 = 0;
            String cliente4 = "";
            int contador4 = 0;

            for (Cliente cliente : clientes){
                int contador = 0;
                for (Pedido pedido : cliente.getPedidos()){
                    contador = contador + 1;
                }
                if (contador>=contador1){
                    String cliAux1 = cliente1;
                    String cliAux2 = cliente2;
                    String cliAux3 = cliente3;
                    int contAux1 = contador1;
                    int contAux2 = contador2;
                    int contAux3 = contador3;

                    cliente1 = cliente.getNombre() + " "+ cliente.getApellido();
                    contador1 = contador;
                    cliente2 = cliAux1;
                    contador2 = contAux1;
                    cliente3 = cliAux2;
                    contador3 = contAux2;
                    cliente4 = cliAux3;
                    contador4 = contAux3;
                }else {
                    if (contador>=contador2){
                        String cliAux1 = cliente2;
                        String cliAux2 = cliente3;
                        int contAux1 = contador2;
                        int contAux2 = contador3;

                        cliente2 = cliente.getNombre() + " "+ cliente.getApellido();
                        contador2 = contador;
                        cliente3 = cliAux1;
                        contador3 = contAux1;
                        cliente4 = cliAux2;
                        contador4 = contAux2;
                    } else {
                        if (contador>=contador3){
                            String cliAux1 = cliente3;
                            int contAux1 = contador3;

                            cliente3 = cliente.getNombre() + " "+ cliente.getApellido();
                            contador3 = contador;
                            cliente4 = cliAux1;
                            contador4 = contAux1;
                        }else {
                            if (contador>=contador4){
                                cliente4 = cliente.getNombre() + " "+ cliente.getApellido();
                                contador4 = contador;
                            }
                        }
                    }
                }
            }
            return "---------------RANKING CLIENTES CON MAS PEDIDOS------------------\n" +
                    "1- "+ cliente1 +"  Cantidad Pedidos: "+ contador1 +"\n" +
                    "2- "+ cliente2 +"  Cantidad Pedidos: "+ contador2 +"\n" +
                    "3- "+ cliente3 +"  Cantidad Pedidos: "+ contador3 +"\n" +
                    "4- "+ cliente4 +"  Cantidad Pedidos: "+ contador4 +"\n";
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String clienteMasImporte() throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findAll();
            String cliente1 = "";
            float contador1 = 0;
            String cliente2 = "";
            float contador2 = 0;
            String cliente3 = "";
            float contador3 = 0;
            String cliente4 = "";
            float contador4 = 0;

            for (Cliente cliente : clientes) {
                float contador = 0;
                for (Pedido pedido : cliente.getPedidos()) {
                    contador = contador + pedido.getTotal();
                }
                if (contador >= contador1) {
                    String cliAux1 = cliente1;
                    String cliAux2 = cliente2;
                    String cliAux3 = cliente3;
                    float contAux1 = contador1;
                    float contAux2 = contador2;
                    float contAux3 = contador3;

                    cliente1 = cliente.getNombre() + " " + cliente.getApellido();
                    contador1 = contador;
                    cliente2 = cliAux1;
                    contador2 = contAux1;
                    cliente3 = cliAux2;
                    contador3 = contAux2;
                    cliente4 = cliAux3;
                    contador4 = contAux3;
                } else {
                    if (contador >= contador2) {
                        String cliAux1 = cliente2;
                        String cliAux2 = cliente3;
                        float contAux1 = contador2;
                        float contAux2 = contador3;

                        cliente2 = cliente.getNombre() + " " + cliente.getApellido();
                        contador2 = contador;
                        cliente3 = cliAux1;
                        contador3 = contAux1;
                        cliente4 = cliAux2;
                        contador4 = contAux2;
                    } else {
                        if (contador >= contador3) {
                            String cliAux1 = cliente3;
                            float contAux1 = contador3;

                            cliente3 = cliente.getNombre() + " " + cliente.getApellido();
                            contador3 = contador;
                            cliente4 = cliAux1;
                            contador4 = contAux1;
                        } else {
                            if (contador >= contador4) {
                                cliente4 = cliente.getNombre() + " " + cliente.getApellido();
                                contador4 = contador;
                            }
                        }
                    }
                }
            }
            return "---------------RANKING CLIENTES CON MAS IMPORTE------------------\n" +
                    "1- " + cliente1 + "  Cantidad Importe: " + contador1 + "\n" +
                    "2- " + cliente2 + "  Cantidad Importe: " + contador2 + "\n" +
                    "3- " + cliente3 + "  Cantidad Importe: " + contador3 + "\n" +
                    "4- " + cliente4 + "  Cantidad Importe: " + contador4 + "\n";

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}

