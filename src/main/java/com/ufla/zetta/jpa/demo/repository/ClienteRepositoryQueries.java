package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Cliente;

import java.util.List;

public interface ClienteRepositoryQueries {

    List<Cliente> findNome(String nome);

}
