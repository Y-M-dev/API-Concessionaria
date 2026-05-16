package com.serratec.trabalho_api.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInserir {
    @NotNull
    private String nome;

    @NotNull
    private String telefone;

    @NotNull
    private String cpf;

    @NotNull
    private String email;
}
