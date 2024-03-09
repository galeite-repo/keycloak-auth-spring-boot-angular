package com.tutorial.keycloakbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.keycloakbackend.infra.EmpresaRepository;

import com.tutorial.keycloakbackend.model.empresa.Empresa;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

     public Empresa save(Empresa empersa) {
        return repository.save(empersa);
    }

    public Empresa getEmpresaSite(String site) {
        Optional<Empresa> empresOptional = repository.findBySite(site);
        return empresOptional.orElse(null); 
    }
    @Transactional
    public List<Empresa> findAll(){
        return repository.findAll();
    }

}
