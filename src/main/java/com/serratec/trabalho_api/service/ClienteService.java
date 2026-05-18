package com.serratec.trabalho_api.service;

import com.serratec.trabalho_api.entity.Cliente;
import com.serratec.trabalho_api.model.ClienteBuscar;
import com.serratec.trabalho_api.model.ClienteInserir;
import com.serratec.trabalho_api.exception.NaoEncontradoException;
import com.serratec.trabalho_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void inserir(ClienteInserir cliente) {
        Cliente inserirCliente = new Cliente(cliente);
        this.clienteRepository.save(inserirCliente);

    }

    public Cliente buscarPorId(UUID id) {
        return clienteRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Não foi encontrado um cliente com esse id"));
    }

    public List<ClienteBuscar> buscar(String nome, String cpf) {
        List<Cliente> clientes = new ArrayList<>();
        if (StringUtils.hasText(nome)) {
            clientes = clienteRepository.findByNomeContainingIgnoreCase(nome);

        } else if (StringUtils.hasText(cpf)) {
            clientes = clienteRepository.findByCpf(cpf);

        } else {
            clientes = clienteRepository.findAll();

        }
        if (clientes.isEmpty()) {
            throw new NaoEncontradoException("Não foi encontrado nenhum dado com os parâmetros");
        }
        return clientes.stream().map(cliente -> new ClienteBuscar(cliente)).toList();
    }

    public void deletar(UUID id) {
        Cliente ciente = buscarPorId(id);
        clienteRepository.delete(ciente);
    }
}
