package com.serratec.trabalho_api.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class ClienteCriar {
    @NotNull
    private String nome;

    @NotNull
    private String telefone;

    @NotNull
    private String cpf;

    @NotNull
    private String email;
}
