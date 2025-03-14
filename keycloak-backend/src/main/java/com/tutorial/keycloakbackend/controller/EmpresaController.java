package com.tutorial.keycloakbackend.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.keycloakbackend.dto.ResponseMessage;
import com.tutorial.keycloakbackend.model.empresa.Empresa;
import com.tutorial.keycloakbackend.service.EmpresaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
@CrossOrigin
public class EmpresaController {
    private final EmpresaService service;

    @PostMapping("/create")
    @RolesAllowed("backend-admin")
    public ResponseEntity<?> save(@RequestBody Empresa empresa) {
        service.save(empresa);
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("save"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    @RolesAllowed("backend-admin")
    public ResponseEntity<List<Empresa>> list() {
        List<Empresa> list = service.findAll();
        return new ResponseEntity<List<Empresa>>(list, HttpStatus.OK);
    }

}
