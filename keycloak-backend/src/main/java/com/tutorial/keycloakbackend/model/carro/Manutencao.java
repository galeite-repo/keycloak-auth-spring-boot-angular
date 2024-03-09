package com.tutorial.keycloakbackend.model.carro;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "manutencao")
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kilometragem;
    private String responsavel;
    private String observacao;
    private Date dataManutencao;
    
    @ManyToOne
    @JoinColumn(name = "carro_id")
     @JsonBackReference
    private Carro carro;
}
