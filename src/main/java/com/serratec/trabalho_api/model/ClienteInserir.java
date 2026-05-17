package com.serratec.trabalho_api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 11, max = 11)
    private String telefone;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    @NotNull
    private String email;
}
