package com.tutorial.keycloakbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.keycloakbackend.infra.ManutencaoRepository;
import com.tutorial.keycloakbackend.model.carro.Manutencao;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository repository;

    public Manutencao cadastrarManutencao(Manutencao manutencao) {
        return repository.save(manutencao);
    }
}