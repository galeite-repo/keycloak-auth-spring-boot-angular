package com.tutorial.keycloakbackend.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.keycloakbackend.infra.ClienteRepository;
import com.tutorial.keycloakbackend.infra.ContatoRepository;
import com.tutorial.keycloakbackend.infra.EnderecoClienteRepository;
import com.tutorial.keycloakbackend.model.cliente.Cliente;
import com.tutorial.keycloakbackend.model.cliente.Contato;
import com.tutorial.keycloakbackend.model.empresa.Empresa;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ContatoRepository repositoryContato;
    private EnderecoClienteRepository repositoryEnderecoCliente;

    @Transactional
    public void deletebyId(Long id) {
        repository.deleteById(id);
    }
    @Transactional
    public Cliente save(Cliente cliente, List<Contato> contatos) {


        repositoryEnderecoCliente.save((cliente.getEndereco()));
        // Associar cada manutenção ao cliente
        for (Contato contato : contatos) {
            contato.setCliente(cliente);
            repositoryContato.save(contato);
        }
        cliente.setContatos(contatos);
        return repository.save(cliente);
    }
    @Transactional
    public List<Cliente> findAll(Empresa empresa){
        return repository.findByEmpresa(empresa);
    }

    
}
