package com.serratec.trabalho_api.service;

import com.serratec.trabalho_api.entity.Cliente;
import com.serratec.trabalho_api.model.ClienteBuscar;
import com.serratec.trabalho_api.model.ClienteInserir;
import com.serratec.trabalho_api.model.NaoEncontradoException;
import com.serratec.trabalho_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void inserir(ClienteInserir cliente){
        Cliente inserirCliente = new Cliente(cliente);
        this.clienteRepository.save(inserirCliente);

    }
    public List<ClienteBuscar> buscar(String nome,String cpf){
        List<Cliente> clientes = new ArrayList<>();
        if (cpf != null && !cpf.isBlank()){clientes = clienteRepository.findByCpf(cpf);}
        if (nome != null && !nome.isBlank()){clientes = clienteRepository.findByNomeIgnoreCase(nome);}
        if (clientes.isEmpty()){throw new NaoEncontradoException("Não foi encontrado nenhum dado com os parâmetros");
        }
        return clientes.stream().map(cliente -> new ClienteBuscar(cliente)).toList();
    }
}
