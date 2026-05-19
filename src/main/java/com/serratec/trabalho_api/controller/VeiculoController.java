package com.serratec.trabalho_api.controller;

import com.serratec.trabalho_api.model.VeiculoAtualizar;
import com.serratec.trabalho_api.model.VeiculoBuscar;
import com.serratec.trabalho_api.model.VeiculoInserir;
import com.serratec.trabalho_api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }
    @PostMapping
    public ResponseEntity<Void> inserir (@Valid @RequestBody VeiculoInserir veiculo){
        this.veiculoService.inserir(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<VeiculoBuscar>> buscar(@RequestParam(required = false) String placa,@RequestParam(required = false) String marca, @RequestParam(required = false) String modelo){
       List<VeiculoBuscar> veiculos = this.veiculoService.buscar(placa,marca,modelo);
       return ResponseEntity.status(HttpStatus.OK).body(veiculos);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        this.veiculoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
   @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID id, @Valid @RequestBody VeiculoAtualizar veiculo){
        this.veiculoService.atualizar(id,veiculo);
        return ResponseEntity.status(HttpStatus.OK).build();
   }
}
