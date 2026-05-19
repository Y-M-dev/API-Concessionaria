package com.serratec.trabalho_api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInserir {
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode estar vazio")
    @Size(min = 11, max = 11, message = "O telefone precisa ter 11 números")
    private String telefone;

    @NotNull(message = "O cpf não pode ser nulo")
    @NotBlank(message = "O cpf não pode estar vazio")
    @Size(min = 11, max = 11, message = "O cpf precisa ter 11 números")
    private String cpf;

    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode estar vazio")
    @Email
    private String email;
}
