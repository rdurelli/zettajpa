package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
