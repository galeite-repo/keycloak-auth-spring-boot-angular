package com.tutorial.keycloakbackend.model.carro;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tutorial.keycloakbackend.model.empresa.Empresa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "carros")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String modelo;
    @Column
    private String marca;
    @Column
    private String ano;
    @Column
    private String placa;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
    private List<Manutencao> manutencoes;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonBackReference
    private Empresa empresa;

}
