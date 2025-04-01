package com.app.BackEnd_AppMed.service;

import com.app.BackEnd_AppMed.model.Tarefa;
import com.app.BackEnd_AppMed.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // Criar uma nova tarefa
    public Tarefa criarTarefa(Tarefa tarefa) {
        // Aqui você pode adicionar qualquer validação ou lógica adicional
        return tarefaRepository.save(tarefa);
    }

    // Listar todas as tarefas
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    // Buscar tarefa por ID
    public Optional<Tarefa> buscarTarefaPorId(UUID id) {
        return tarefaRepository.findById(id);
    }

    // Buscar tarefas por status
    public List<Tarefa> buscarTarefasPorStatus(boolean status) {
        return tarefaRepository.findByStatus(status);
    }

    // Buscar tarefas por dia da semana
    public List<Tarefa> buscarTarefasPorDiaSemana(String diaSemana) {
        return tarefaRepository.findByDiaSemana(diaSemana);
    }

    // Atualizar uma tarefa existente
    public Tarefa atualizarTarefa(UUID id, Tarefa tarefaAtualizada) {
        if (tarefaRepository.existsById(id)) {
            tarefaAtualizada.setId(id);
            return tarefaRepository.save(tarefaAtualizada);
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }

    // Excluir uma tarefa
    public void excluirTarefa(UUID id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }

    // Atualizar o status de uma tarefa
    public Tarefa atualizarStatus(UUID id, boolean status) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            Tarefa tarefa = tarefaOptional.get();
            tarefa.setStatus(status);
            return tarefaRepository.save(tarefa);
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }
}
