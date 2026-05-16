package com.serratec.trabalho_api.repository;

import com.serratec.trabalho_api.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {

    List<Veiculo> findByPlaca(String placa);

    List<Veiculo> findByMarca(String marca);

    List<Veiculo> findByModelo(String modelo);

}
