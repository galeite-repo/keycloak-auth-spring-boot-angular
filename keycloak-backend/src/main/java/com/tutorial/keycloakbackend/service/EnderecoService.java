package com.tutorial.keycloakbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tutorial.keycloakbackend.model.Endereco;

@Service
public class EnderecoService {
    private final String VIA_CEP_URL = "https://viacep.com.br/ws/";

    public Endereco consultarCep(String cep) {
        String url = VIA_CEP_URL + cep + "/json";
        RestTemplate restTemplate = new RestTemplate();
        Endereco resultado = restTemplate.getForObject(url, Endereco.class);
        return resultado;
    }
}
