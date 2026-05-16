package com.serratec.trabalho_api.repository;

import com.serratec.trabalho_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {


}
