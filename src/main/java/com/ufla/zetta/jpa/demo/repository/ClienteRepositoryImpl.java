package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepositoryQueries{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cliente> findNome(String nome) {
        String jpql = "from Cliente where nome like :nome";
        return manager
                .createQuery(jpql, Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }

}
