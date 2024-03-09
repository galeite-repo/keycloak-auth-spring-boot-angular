package com.tutorial.keycloakbackend.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.keycloakbackend.dto.ResponseMessage;
import com.tutorial.keycloakbackend.model.cliente.Cliente;
import com.tutorial.keycloakbackend.model.cliente.Contato;
import com.tutorial.keycloakbackend.model.empresa.Empresa;
import com.tutorial.keycloakbackend.service.ClienteService;
import com.tutorial.keycloakbackend.service.EmpresaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@CrossOrigin
public class ClienteController {
    private final ClienteService service;
    private final EmpresaService empresaService;

    @PostMapping("/create/{site}")
    @RolesAllowed("backend-user")
    public ResponseEntity<?> save(@RequestBody Cliente cliente, @PathVariable String site) {
        List<Contato> contatos = new ArrayList<>();
        Empresa empresa = new Empresa();
        empresa = empresaService.getEmpresaSite(site);
        cliente.setEmpresa(empresa);
        contatos = cliente.getContatos();
        service.save(cliente, contatos);
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("save"), HttpStatus.CREATED);
    }

    @GetMapping("/list/{site}")
    @RolesAllowed("backend-user")
    public ResponseEntity<List<Cliente>> list(@PathVariable String site) {
        Empresa empresa = new Empresa();
        empresa = empresaService.getEmpresaSite(site);
        List<Cliente> list = service.findAll(empresa);
        return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @RolesAllowed("backend-user")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletebyId(id);
        return ResponseEntity.noContent().build();
    }
}
