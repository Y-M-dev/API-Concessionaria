package com.serratec.trabalho_api.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoInserir {

    @NotNull
    private UUID clienteId;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private Integer ano;

    @NotNull
    private float valor;

    @NotNull
    private String placa;

    @NotNull
    private float maximoDesconto;

}
