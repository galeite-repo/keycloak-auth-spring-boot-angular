package com.tutorial.keycloakbackend.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.keycloakbackend.infra.CarroRepository;
import com.tutorial.keycloakbackend.infra.ManutencaoRepository;
import com.tutorial.keycloakbackend.model.carro.Carro;
import com.tutorial.keycloakbackend.model.carro.Manutencao;
import com.tutorial.keycloakbackend.model.empresa.Empresa;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarroService {
    @Autowired
    private CarroRepository repository;
    @Autowired
    private ManutencaoRepository repositoryManutencao;

    @Transactional
    public void deletebyId(Long id) {
        repository.deleteById(id);
    }
    @Transactional
    public Carro save(Carro carro, List<Manutencao> manutencoes) {

        // Associar cada manutenção ao carro
        for (Manutencao manutencao : manutencoes) {
            manutencao.setCarro(carro);
            repositoryManutencao.save(manutencao);
        }
        carro.setManutencoes(manutencoes);
        return repository.save(carro);
    }
    @Transactional
    public List<Carro> findAll(Empresa empresa){
        return repository.findByEmpresa(empresa);
    }

    
}
