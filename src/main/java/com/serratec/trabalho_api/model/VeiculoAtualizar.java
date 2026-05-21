package com.serratec.trabalho_api.model;

import jakarta.validation.constraints.AssertTrue;
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
    private Integer ano;

    @Min(value = 1, message = "O valor precisa ser maior que 0")
    @NotNull(message = "O valor não pode ser nulo")
    private float valor;


    @Min(value = 0, message = "O desconto não pode ser negativo")
    @NotNull(message = "O desconto não pode ser nulo")
    private float maximoDesconto;

    @NotNull(message = "Status de vendido não pode ser nulo")
    private boolean vendido;

    @Min(value = 1, message = "O valor da venda precisa ser maior que 0")
    @NotNull(message = "O valor da venda não pode ser nulo")
    private double valorVenda;

    @AssertTrue(message = "Valor da venda precisa ser maior que 0 se o veículo foi vendido")
    public boolean isVendido() {
        if (vendido && valorVenda <= 0) {
            return false;
        }
        return true;
    }
    @AssertTrue(message = "Não é possível colocar o valor da venda se o veículo não foi marcado como vendido")
    public boolean isValorVendido() {
        if (!vendido && valorVenda >= 1) {
            return false;
        }
        return true;
    }
}
