package com.serratec.trabalho_api.model;

import com.serratec.trabalho_api.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteBuscar {
    private UUID id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;

    public ClienteBuscar(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }
}
