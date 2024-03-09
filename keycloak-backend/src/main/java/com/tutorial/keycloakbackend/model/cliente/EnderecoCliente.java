package com.tutorial.keycloakbackend.model.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "endereco_cliente")
public class EnderecoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String cep;
    @Column()
    private String logradouro;
    @Column()
    private String localidade;
    @Column()
    private String bairro;
    @Column()
    private String uf;
    @Column()
    private String numero;
    @Column()
    private String complemento;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

}
