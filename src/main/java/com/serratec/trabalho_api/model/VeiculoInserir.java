package com.serratec.trabalho_api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoInserir {
    @NotNull(message = "O Id do cliente não pode ser nulo")
    @NotBlank(message = "O Id do cliente não pode estar vazio")
    private UUID clienteId;

    @NotNull(message = "A placa não pode ser nula")
    @NotBlank(message = "A placa não pode estar vazia")
    private String placa;

    @NotNull(message = "A marca não pode ser nula")
    @NotBlank(message = "A marca não pode estar vazia")
    private String marca;

    @NotNull(message = "O modelo não pode ser nulo")
    @NotBlank(message = "O modelo não pode estar vazio")
    private String modelo;

    @Min(value = 1900, message = "O ano não pode ser menor que 1900")
    @NotNull(message = "O ano não pode ser nulo")
    @NotBlank(message = "O ano não pode estar vazio")
    private Integer ano;

    @Min(value = 1, message = "O valor precisa ser maior que 0")
    @NotNull(message = "O valor não pode ser nulo")
    @NotBlank(message = "O valor não pode estar vazio")
    private float valor;


    @Min(value = 0, message = "O desconto não poder ser negativo")
    @NotNull(message = "O desconto não pode ser nulo")
    @NotBlank(message = "O desconto não pode estar vazio")
    private float maximoDesconto;

}
