package com.serratec.trabalho_api.service;

import com.serratec.trabalho_api.entity.Cliente;
import com.serratec.trabalho_api.entity.Veiculo;
import com.serratec.trabalho_api.exception.EntidadeDuplicadaException;
import com.serratec.trabalho_api.exception.NaoEncontradoException;
import com.serratec.trabalho_api.model.VeiculoAtualizar;
import com.serratec.trabalho_api.model.VeiculoBuscar;
import com.serratec.trabalho_api.model.VeiculoInserir;
import com.serratec.trabalho_api.repository.ClienteRepository;
import com.serratec.trabalho_api.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void inserir(VeiculoInserir veiculo) {
        if (veiculoRepository.findByPlacaIgnoreCase(veiculo.getPlaca()).isPresent()){
            throw new EntidadeDuplicadaException("Veículo com placa " +  veiculo.getPlaca() + " já existe");
        }
        Cliente cliente = clienteRepository.findById(veiculo.getClienteId()).orElseThrow(() -> new NaoEncontradoException("O cliente com id " + veiculo.getClienteId() + " não foi encontrado"));
        Veiculo inserirVeiculo = new Veiculo(veiculo, cliente);
        this.veiculoRepository.save(inserirVeiculo);
    }

    public Veiculo buscarPorId(UUID id){
        return veiculoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Não foi encontrado um cliente com esse id"));

    }

    public List<VeiculoBuscar> buscar(String placa, String marca, String modelo) {
        List<Veiculo> veiculos = new ArrayList<>();

        if (StringUtils.hasText(placa)) {
            Veiculo veiculo = veiculoRepository.findByPlacaIgnoreCase(placa)
                    .orElseThrow(() -> new NaoEncontradoException("Não foi encontrado nenhum veículo com a placa informada"));
            veiculos.add(veiculo);

        } else if (StringUtils.hasText(marca)) {
            veiculos = veiculoRepository.findByMarcaContainingIgnoreCase(marca);

        } else if (StringUtils.hasText(modelo)) {
            veiculos = veiculoRepository.findByModeloContainingIgnoreCase(modelo);

        } else{
            veiculos = veiculoRepository.findAll();

        }
        if (veiculos.isEmpty()){
            throw new NaoEncontradoException("Não foi encontrado nenhum dado com os parâmetros");
        }

            return veiculos.stream().map(veiculo -> new VeiculoBuscar(veiculo)).toList();
    }

    public void deletar(UUID id){
        Veiculo veiculo = buscarPorId(id);
        veiculoRepository.delete(veiculo);

    }
    public void atualizar(UUID id, VeiculoAtualizar veiculoAtt){
        Veiculo atualizarVeiculo = veiculoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("O veículo não foi encontrado"));
        Veiculo veiculo = new Veiculo(veiculoAtt);
        veiculo.setId(atualizarVeiculo.getId());
        veiculo.setClienteId(atualizarVeiculo.getClienteId());
        veiculo.setPlaca(atualizarVeiculo.getPlaca());
        veiculoRepository.save(veiculo);

    }
}

