package com.tutorial.keycloakbackend.model.empresa;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tutorial.keycloakbackend.model.carro.Carro;
import com.tutorial.keycloakbackend.model.cliente.Cliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cnpj;
    @Column
    private String site;
    @Column
    private String email;
    @Column
    private String telefone;
    @Column
    private String cep;
    @Column
    private String logradouro;
    @Column
    private String numero;
    @Column
    private String complemento;
    @Column
    private String bairro;
    @Column
    private String cidade;
    @Column
    private String uf;
    @Column
    private Boolean active;
    @Lob
    private byte[] logo;
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Carro> carros;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Cliente> clientes;
}
