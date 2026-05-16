package com.serratec.trabalho_api.controller;

import com.serratec.trabalho_api.model.ClienteInserir;
import com.serratec.trabalho_api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
