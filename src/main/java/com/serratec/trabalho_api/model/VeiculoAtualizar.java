package com.serratec.trabalho_api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoAtualizar {
    @NotNull(message = "A marca não pode ser nula")
    @NotBlank(message = "A marca não pode estar vazia")
    private String marca;

    @NotNull(message = "O modelo não pode ser nulo")
    @NotBlank(message = "O modelo não pode estar vazio")
    private String modelo;

    @Min(1900)
    @NotNull(message = "O ano não pode ser nulo")
    @NotBlank(message = "O ano não pode estar vazio")
    private Integer ano;

    @Min(value = 1, message = "O valor precisa ser maior que 0")
    @NotNull(message = "O valor não pode ser nulo")
    @NotBlank(message = "O valor não pode estar vazio")
    private float valor;


    @Min(value = 0, message = "O desconto não pode ser negativo")
    @NotNull(message = "O desconto não pode ser nulo")
    @NotBlank(message = "O desconto não pode estar vazio")
    private float maximoDesconto;

    @NotNull(message = "Status de vendido não pode ser nulo")
    @NotBlank(message = "Status de vendido não pode estar vazio")
    private boolean vendido;

    @Min(value = 1, message = "O valor da venda precisa ser maior que 0")
    @NotNull(message = "O valor da venda não pode ser nulo")
    @NotBlank(message = "O valor da venda não pode estar vazio")
    private double valorVenda;

}
