package com.app.BackEnd_AppMed.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;  // Chave primária do usuário (UUID)

    @Column(nullable = false)
    private String nome;  // Nome do usuário

    @Column(nullable = false, unique = true)
    private String email;  // Email do usuário (único e não nulo)

    private String telefone;  // Telefone do usuário

    @Column(name = "data_cadastro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp dataCadastro;  // Data de cadastro do usuário

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public java.sql.Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(java.sql.Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}