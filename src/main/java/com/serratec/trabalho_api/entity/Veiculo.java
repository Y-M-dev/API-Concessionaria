package com.serratec.trabalho_api.entity;

import com.serratec.trabalho_api.model.VeiculoAtualizar;
import com.serratec.trabalho_api.model.VeiculoInserir;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteId;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private float valor;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private float maximoDesconto;

    @Column
    private boolean vendido;

    @Column
    private double valorVenda;

    public Veiculo(VeiculoInserir veiculo, Cliente cliente) {
        this.clienteId = cliente;
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.valor = veiculo.getValor();
        this.placa = veiculo.getPlaca();
        this.maximoDesconto = veiculo.getMaximoDesconto();
        this.vendido = false;
//      this.valorVenda = 0.0;
    }

    public Veiculo(VeiculoAtualizar veiculo) {
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.valor = veiculo.getValor();
        this.maximoDesconto = veiculo.getMaximoDesconto();
        this.vendido = veiculo.isVendido();
        this.valorVenda = veiculo.getValorVenda();
    }
}
