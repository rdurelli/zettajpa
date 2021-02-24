package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<Produto> findByNomeAndPreco(String nome, Double preco);
}
