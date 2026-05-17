package com.serratec.trabalho_api.entity;

import com.serratec.trabalho_api.model.ClienteInserir;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 11)
    private String nome;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    public Cliente(ClienteInserir cliente){

        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }
}
