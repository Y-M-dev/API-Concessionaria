package com.serratec.trabalho_api.model;

import com.serratec.trabalho_api.entity.Cliente;
import com.serratec.trabalho_api.entity.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoBuscar {
    private UUID id;
    private UUID idCliente;
    private String marca;
    private String modelo;
    private Integer ano;
    private float valor;
    private String placa;
    private float maximoDesconto;
    private boolean vendido;
    private double valorVenda;

    public VeiculoBuscar(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.idCliente = veiculo.getClienteId().getId();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.valor = veiculo.getValor();
        this.placa = veiculo.getPlaca();
        this.maximoDesconto = veiculo.getMaximoDesconto();
        this.vendido = veiculo.isVendido();
        this.valorVenda = veiculo.getValorVenda();
    }
}
