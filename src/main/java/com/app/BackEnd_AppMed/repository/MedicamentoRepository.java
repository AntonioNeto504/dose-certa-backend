package com.app.BackEnd_AppMed.repository;

import com.app.BackEnd_AppMed.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, UUID> {
    // Aqui você pode adicionar métodos personalizados se necessário
}