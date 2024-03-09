package com.tutorial.keycloakbackend.model.cliente;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tutorial.keycloakbackend.model.empresa.Empresa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String nome;
    @Column()
    private String rg;
    @Column()
    private String cpf;
    @Column()
    private String cnpj;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Contato> contatos;
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private EnderecoCliente endereco;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonBackReference
    private Empresa empresa;
}
