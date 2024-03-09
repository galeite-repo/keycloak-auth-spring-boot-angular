package com.tutorial.keycloakbackend.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.keycloakbackend.model.carro.Carro;
import com.tutorial.keycloakbackend.model.empresa.Empresa;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{
    void deleteById(Long id);
     List<Carro> findByEmpresa(Empresa empresa);

}
