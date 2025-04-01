package com.app.BackEnd_AppMed.controller;

import com.app.BackEnd_AppMed.model.Tarefa;
import com.app.BackEnd_AppMed.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    // Endpoint para criar uma nova tarefa
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.ok(novaTarefa);
    }

    // Endpoint para listar todas as tarefas
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        return ResponseEntity.ok(tarefas);
    }

    // Endpoint para buscar uma tarefa pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable UUID id) {
        Optional<Tarefa> tarefa = tarefaService.buscarTarefaPorId(id);
        return tarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para buscar tarefas por status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Tarefa>> buscarTarefasPorStatus(@PathVariable boolean status) {
        List<Tarefa> tarefas = tarefaService.buscarTarefasPorStatus(status);
        return ResponseEntity.ok(tarefas);
    }

    // Endpoint para buscar tarefas por dia da semana
    @GetMapping("/dia/{diaSemana}")
    public ResponseEntity<List<Tarefa>> buscarTarefasPorDiaSemana(@PathVariable String diaSemana) {
        List<Tarefa> tarefas = tarefaService.buscarTarefasPorDiaSemana(diaSemana);
        return ResponseEntity.ok(tarefas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable UUID id, @RequestBody Tarefa tarefaAtualizada) {
        try {
            Tarefa tarefa = tarefaService.atualizarTarefa(id, tarefaAtualizada);
            return ResponseEntity.ok(tarefa);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Endpoint para excluir uma tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable UUID id) {
        try {
            tarefaService.excluirTarefa(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    // Endpoint para atualizar o status de uma tarefa
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<Tarefa> atualizarStatus(@PathVariable UUID id, @PathVariable boolean status) {
        try {
            Tarefa tarefaAtualizada = tarefaService.atualizarStatus(id, status);
            return ResponseEntity.ok(tarefaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
