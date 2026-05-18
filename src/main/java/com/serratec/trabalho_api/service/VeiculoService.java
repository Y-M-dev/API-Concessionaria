package com.serratec.trabalho_api.service;

import com.serratec.trabalho_api.entity.Cliente;
import com.serratec.trabalho_api.entity.Veiculo;
import com.serratec.trabalho_api.exception.NaoEncontradoException;
import com.serratec.trabalho_api.model.ClienteBuscar;
import com.serratec.trabalho_api.model.VeiculoBuscar;
import com.serratec.trabalho_api.model.VeiculoInserir;
import com.serratec.trabalho_api.repository.ClienteRepository;
import com.serratec.trabalho_api.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void inserir(VeiculoInserir veiculo) {
        Cliente cliente = clienteRepository.findById(veiculo.getClienteId()).orElseThrow(() -> new NaoEncontradoException("O cliente com id " + veiculo.getClienteId() + " não foi encontrado"));
        Veiculo inserirVeiculo = new Veiculo(veiculo, cliente);
        this.veiculoRepository.save(inserirVeiculo);
    }

    public List<VeiculoBuscar> buscar(String placa, String marca, String modelo) {
        List<Veiculo> veiculos = new ArrayList<>();

        if (StringUtils.hasText(placa)) {
            veiculos = veiculoRepository.findByPlacaContainingIgnoreCase(placa);

        } else if (StringUtils.hasText(marca)) {
            veiculos = veiculoRepository.findByMarcaContainingIgnoreCase(marca);

        } else if (StringUtils.hasText(modelo)) {
            veiculos = veiculoRepository.findByModeloContainingIgnoreCase(modelo);

        } else if (!StringUtils.hasText(placa) && !StringUtils.hasText(marca) && !StringUtils.hasText(modelo)) {
            veiculos = veiculoRepository.findAll();

        } else if (veiculos.isEmpty()){
            throw new NaoEncontradoException("Não foi encontrado nenhum dado com os parâmetros");
        }

            return veiculos.stream().map(veiculo -> new VeiculoBuscar(veiculo)).toList();
    }
}

