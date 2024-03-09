package com.tutorial.keycloakbackend.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.keycloakbackend.model.empresa.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

    Optional<Empresa> findBySite(String site);
    
}
