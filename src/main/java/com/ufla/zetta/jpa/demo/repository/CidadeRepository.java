package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
