package com.app.BackEnd_AppMed.controller;

import com.app.BackEnd_AppMed.model.Medicamento;
import com.app.BackEnd_AppMed.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    // Endpoint para salvar ou atualizar um medicamento
    @PostMapping
    public ResponseEntity<Medicamento> salvarMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento savedMedicamento = medicamentoService.salvarMedicamento(medicamento);
        return new ResponseEntity<>(savedMedicamento, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os medicamentos
    @GetMapping
    public ResponseEntity<List<Medicamento>> buscarTodos() {
        List<Medicamento> medicamentos = medicamentoService.buscarTodos();
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }

    // Endpoint para buscar um medicamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> buscarPorId(@PathVariable UUID id) {
        Optional<Medicamento> medicamentoOptional = medicamentoService.buscarPorId(id);
        return medicamentoOptional.map(medicamento -> new ResponseEntity<>(medicamento, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para deletar um medicamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedicamento(@PathVariable UUID id) {
        medicamentoService.deletarMedicamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para atualizar a quantidade de um medicamento
    @PutMapping("/{id}/quantidade")
    public ResponseEntity<Medicamento> atualizarQuantidade(@PathVariable UUID id, @RequestBody int novaQuantidade) {
        Medicamento medicamento = medicamentoService.atualizarQuantidade(id, novaQuantidade);
        if (medicamento != null) {
            return new ResponseEntity<>(medicamento, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
