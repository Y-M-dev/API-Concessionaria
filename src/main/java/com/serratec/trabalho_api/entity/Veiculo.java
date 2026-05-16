package com.serratec.trabalho_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID idCliente;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer  ano;

    @Column(nullable = false)
    private float valor;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String maximoDesconto;

    @Column(nullable = false)
    private boolean vendido;

    @Column(nullable = false)
    private double valorVenda;

}
