package com.tutorial.keycloakbackend.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.tutorial.keycloakbackend.exception.ConsultaCepException;
import com.tutorial.keycloakbackend.model.Endereco;
import com.tutorial.keycloakbackend.model.empresa.Empresa;
import com.tutorial.keycloakbackend.service.EnderecoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
@CrossOrigin
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    @RolesAllowed("backend-user")
    public ResponseEntity<Endereco> endereco(@PathVariable String cep) {
        Endereco endereco = enderecoService.consultarCep(cep);
        return new ResponseEntity<>(endereco, HttpStatus.OK);

    }
}
