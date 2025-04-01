package com.app.BackEnd_AppMed.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;  // Chave primária UUID

    @Column(nullable = false, length = 255)
    private String descricao;  // Descrição da tarefa

    @Column(nullable = false)
    private LocalTime hora;  // Hora da tarefa

    @Column(nullable = false, length = 9)
    private String diaSemana;  // Dia da semana em que a tarefa ocorre (Seg, Ter, ...)

    @Column(nullable = false)
    private boolean status;  // Status da tarefa (completa ou não)

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;  // Data de cadastro da tarefa

    // Construtores
    public Tarefa() {
        this.dataCadastro = LocalDateTime.now();  // Preenche a data de cadastro com o momento atual
    }

    public Tarefa(String descricao, LocalTime hora, String diaSemana, boolean status) {
        this.descricao = descricao;
        this.hora = hora;
        this.diaSemana = diaSemana;
        this.status = status;
        this.dataCadastro = LocalDateTime.now();  // Preenche a data de cadastro com o momento atual
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
