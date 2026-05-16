package com.serratec.trabalho_api.repository;

import com.serratec.trabalho_api.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {


}
