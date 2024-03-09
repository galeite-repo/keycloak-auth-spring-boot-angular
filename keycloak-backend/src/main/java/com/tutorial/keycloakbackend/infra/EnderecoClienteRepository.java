package com.tutorial.keycloakbackend.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.keycloakbackend.model.cliente.EnderecoCliente;

@Repository
public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente, Long>{

}
