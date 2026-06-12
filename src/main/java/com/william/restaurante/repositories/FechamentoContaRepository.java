package com.william.restaurante.repositories;

import com.william.restaurante.domain.entities.FechamentoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FechamentoContaRepository extends JpaRepository<FechamentoConta, Long> {
}
