package com.serratec.trabalho_api.controller;

import com.serratec.trabalho_api.entity.Veiculo;
import com.serratec.trabalho_api.model.VeiculoBuscar;
import com.serratec.trabalho_api.model.VeiculoInserir;
import com.serratec.trabalho_api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping()
    public ResponseEntity<List<VeiculoBuscar>> buscar(@RequestParam(required = false) String placa,@RequestParam(required = false) String marca, @RequestParam(required = false) String modelo){
       List<VeiculoBuscar> veiculos = this.veiculoService.buscar(placa,marca,modelo);
       return ResponseEntity.status(HttpStatus.OK).body(veiculos);
   }
}
