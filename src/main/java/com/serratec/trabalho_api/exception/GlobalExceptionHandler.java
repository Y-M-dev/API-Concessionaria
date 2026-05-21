package com.serratec.trabalho_api.exception;

import com.serratec.trabalho_api.model.ErroResposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResposta(LocalDateTime.now(), "BAD_REQUEST", erros));
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ErroResposta> handleNaoEncontrado(NaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroResposta(LocalDateTime.now(), "NOT_FOUND", List.of(ex.getMessage())));
    }

    @ExceptionHandler(EntidadeDuplicadaException.class)
    public ResponseEntity<ErroResposta> handleDuplicado(EntidadeDuplicadaException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErroResposta(LocalDateTime.now(), "CONFLICT", List.of(ex.getMessage())));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> handleErroInterno(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErroResposta(LocalDateTime.now(),"INTERNAL_SERVER_ERROR",List.of("Erro interno no servidor")));
    }
}
