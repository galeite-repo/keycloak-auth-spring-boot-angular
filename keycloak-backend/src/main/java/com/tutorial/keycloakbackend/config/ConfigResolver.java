package com.tutorial.keycloakbackend.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigResolver {
    

    public KeycloakConfigResolver keycloakConfigResolver (){
        return new KeycloakSpringBootConfigResolver();
    }
}
