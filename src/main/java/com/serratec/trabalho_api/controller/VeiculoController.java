package com.serratec.trabalho_api.controller;

import com.serratec.trabalho_api.model.VeiculoInserir;
import com.serratec.trabalho_api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }
    @PostMapping
    public ResponseEntity<Void> inserir (@Valid @RequestBody VeiculoInserir veiculo){
        this.veiculoService.inserir(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
