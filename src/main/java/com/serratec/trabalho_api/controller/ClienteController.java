package com.serratec.trabalho_api.controller;

import com.serratec.trabalho_api.model.ClienteBuscar;
import com.serratec.trabalho_api.model.ClienteInserir;
import com.serratec.trabalho_api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> criarCliente(@Valid @RequestBody ClienteInserir cliente){
        this.clienteService.inserir(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<ClienteBuscar>> buscar(@RequestParam(required = false) String nome,@RequestParam(required = false)String cpf){
        List<ClienteBuscar> clientes = this.clienteService.buscar(nome,cpf);
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        this.clienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
