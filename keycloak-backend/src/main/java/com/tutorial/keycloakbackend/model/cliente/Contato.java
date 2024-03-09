package com.tutorial.keycloakbackend.model.cliente;

import javax.persistence.Column;
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
@Table(name = "contatos")
public class Contato {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        @Column()
    private String tipo;
    @Column()
    private String contato;
    @Column()
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;
}
