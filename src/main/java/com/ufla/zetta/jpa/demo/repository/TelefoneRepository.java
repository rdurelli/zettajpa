package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
}
