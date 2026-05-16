package com.serratec.trabalho_api.service;

import com.serratec.trabalho_api.entity.Cliente;
import com.serratec.trabalho_api.entity.Veiculo;
import com.serratec.trabalho_api.model.NaoEncontradoException;
import com.serratec.trabalho_api.model.VeiculoInserir;
import com.serratec.trabalho_api.repository.ClienteRepository;
import com.serratec.trabalho_api.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoService (VeiculoRepository veiculoRepository, ClienteRepository clienteRepository){
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void inserir(VeiculoInserir veiculo){
        Cliente cliente = clienteRepository.findById(veiculo.getClienteId()).orElseThrow(() -> new NaoEncontradoException("O cliente com id " + veiculo.getClienteId() + " não foi encontrado"));
        Veiculo inserirVeiculo = new Veiculo(veiculo,cliente);
        this.veiculoRepository.save(inserirVeiculo);
    }
}
