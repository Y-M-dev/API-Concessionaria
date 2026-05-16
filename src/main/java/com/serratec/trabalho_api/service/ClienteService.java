package com.serratec.trabalho_api.service;

import com.serratec.trabalho_api.entity.Cliente;
import com.serratec.trabalho_api.model.ClienteInserir;
import com.serratec.trabalho_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

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
}
