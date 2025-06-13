package com.example.admindesktop.model;

import com.example.admindesktop.model.value.Email;
import com.example.admindesktop.model.value.Telefone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String senha;
    private String perfil;
    private String nome;
    private String sobrenome;

    @Embedded
    private Telefone telefone;

    private String cep;
    private String localidade;
    private String uf;

    @Embedded
    private Email email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}