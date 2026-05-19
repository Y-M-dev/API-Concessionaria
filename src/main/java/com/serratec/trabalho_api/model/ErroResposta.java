package com.serratec.trabalho_api.model;

import java.time.LocalDateTime;
import java.util.List;

public record ErroResposta(LocalDateTime timestamp, String status, List<String> erros) {
}
