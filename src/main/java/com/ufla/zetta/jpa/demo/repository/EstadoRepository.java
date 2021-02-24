package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
