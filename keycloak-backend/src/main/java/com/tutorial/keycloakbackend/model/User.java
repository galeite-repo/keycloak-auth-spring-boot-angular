package com.tutorial.keycloakbackend.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User implements Serializable{
    
    private static final long serialVersionUID = -1L;

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    
}
