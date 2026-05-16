package com.serratec.trabalho_api.model;

import com.serratec.trabalho_api.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteBuscar {
    private String nome;
    private String telefone;
    private String cpf;
    private String email;

    public ClienteBuscar(Cliente cliente) {
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }
}
