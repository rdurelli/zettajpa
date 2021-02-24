package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Endereco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, Integer> {
}
