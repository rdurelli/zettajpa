package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
