package com.ufla.zetta.jpa.demo.repository.especification;

import com.ufla.zetta.jpa.demo.model.Cliente;

import com.ufla.zetta.jpa.demo.model.Cliente_;
import org.springframework.data.jpa.domain.Specification;

public class ClienteSpecification {

    public static Specification<Cliente> nome(String nome) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Cliente_.nome), nome));
    }

    public static Specification<Cliente> email(String email) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Cliente_.email), email));
    }

}
