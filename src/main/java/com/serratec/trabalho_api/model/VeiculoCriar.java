package com.serratec.trabalho_api.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class VeiculoCriar {

    @NotNull
    private UUID idCliente;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private Integer  ano;

    @NotNull
    private float valor;

    @NotNull
    private String placa;

    @NotNull
    private String maximoDesconto;

    @NotNull
    private boolean vendido;

    @NotNull
    private double valorVenda;
}
