package com.tutorial.keycloakbackend.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.keycloakbackend.model.cliente.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
