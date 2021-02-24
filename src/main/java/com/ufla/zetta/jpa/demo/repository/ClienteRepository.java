package com.ufla.zetta.jpa.demo.repository;

import com.ufla.zetta.jpa.demo.model.Cliente;
import org.jboss.jandex.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>,
        ClienteRepositoryQueries, JpaSpecificationExecutor<Cliente>{

    List<Cliente> findNome(String nome);

    @Query("from Cliente c where c.email like %:email")
    List<Cliente> consultarPorEmail(String email);

    List<Cliente> consultarPorNome(String nome);

    List<Cliente> findByNomeContaining(String nome);

    List<Cliente> findByNomeOrEmail(String nome, String email);

    Optional<Cliente> findFirstByNomeContaining(String nome);

    List<ClassInfo> findTop4ByNomeContaining(String nome);

    Boolean existsByNome(String nome);

    Boolean existsByNomeAndCpfOuCnpj(String nome, String cpfOuCnpj);

    Integer countByNome(String nome);


}
