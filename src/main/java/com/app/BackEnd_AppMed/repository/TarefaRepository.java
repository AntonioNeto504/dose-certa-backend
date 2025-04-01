package com.app.BackEnd_AppMed.repository;

import com.app.BackEnd_AppMed.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

    List<Tarefa> findByStatus(boolean status);

    List<Tarefa> findByDiaSemana(String diaSemana);

    List<Tarefa> findByDiaSemanaAndStatus(String diaSemana, boolean status);

    List<Tarefa> findByDescricaoContaining(String descricao);
}
