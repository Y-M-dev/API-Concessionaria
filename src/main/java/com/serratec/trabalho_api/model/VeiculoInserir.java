package com.serratec.trabalho_api.model;

import jakarta.validation.constraints.Min;
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

    @Min(1900)
    @NotNull
    private Integer ano;

    @Min(1)
    @NotNull
    private float valor;

    @NotNull
    private String placa;

    @Min(0)
    @NotNull
    private float maximoDesconto;

}
