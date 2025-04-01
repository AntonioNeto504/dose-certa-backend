package com.app.BackEnd_AppMed.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(length = 255)
    private String dosagem;

    @Column(length = 255)
    private String frequencia;

    @Column(name = "quantidade_total", nullable = false)
    private int quantidadeTotal;

    // Construtor padrão (sem argumentos)
    public Medicamento() {}

    // Construtor com todos os parâmetros
    public Medicamento(UUID id, String nome, String dosagem, String frequencia, int quantidadeTotal) {
        this.id = id;
        this.nome = nome;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.quantidadeTotal = quantidadeTotal;
    }

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

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    // Método toString
    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", frequencia='" + frequencia + '\'' +
                ", quantidadeTotal=" + quantidadeTotal +
                '}';
    }
}
