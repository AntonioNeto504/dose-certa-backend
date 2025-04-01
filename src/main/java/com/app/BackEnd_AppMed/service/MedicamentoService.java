package com.app.BackEnd_AppMed.service;

import com.app.BackEnd_AppMed.model.Medicamento;
import com.app.BackEnd_AppMed.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    @Autowired
    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    // Método para salvar ou atualizar um medicamento
    public Medicamento salvarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    // Método para buscar todos os medicamentos
    public List<Medicamento> buscarTodos() {
        return medicamentoRepository.findAll();
    }

    // Método para buscar um medicamento por ID
    public Optional<Medicamento> buscarPorId(UUID id) {
        return medicamentoRepository.findById(id);
    }

    // Método para deletar um medicamento por ID
    public void deletarMedicamento(UUID id) {
        medicamentoRepository.deleteById(id);
    }

    // Método para atualizar a quantidade total de um medicamento
    public Medicamento atualizarQuantidade(UUID id, int novaQuantidade) {
        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(id);
        if (medicamentoOptional.isPresent()) {
            Medicamento medicamento = medicamentoOptional.get();
            //medicamento.setQuantidadeTotal(novaQuantidade);
            return medicamentoRepository.save(medicamento);
        }
        return null;
    }
}
