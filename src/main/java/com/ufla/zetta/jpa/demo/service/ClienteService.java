package com.ufla.zetta.jpa.demo.service;

import com.ufla.zetta.jpa.demo.exception.ObjectNotFoundException;
import com.ufla.zetta.jpa.demo.model.Cliente;
import com.ufla.zetta.jpa.demo.repository.ClienteRepository;
import com.ufla.zetta.jpa.demo.repository.especification.ClienteSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente findClienteById(Integer id) {
        return this.clienteRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    public Cliente findByFirstCliente(String nome) {
        return this.clienteRepository.findFirstByNomeContaining(nome).orElseThrow(() ->
                new ObjectNotFoundException("Nenhum Cliente encontrado com o nome: " + nome));
    }

    public List<Cliente> consultarOnLine(String nome, String email) {
        List<Cliente> allCliente = this.clienteRepository.findAll(Specification
                .where(ClienteSpecification.nome(nome)
                        .and(ClienteSpecification.email(email))));
        return allCliente;
    }



//    public List<Cliente> consultarClientePorNome(String nome) {
//        return this.clienteRepository.consultarPorNome(nome);
//    }
//
//    public List<Cliente> consultar(String nome, String email) {
//        List<Cliente> allCliente = this.clienteRepository
//                .findAll(Specification
//                        .where(ClienteSpecification.nome(nome)
//                                .and(ClienteSpecification.email(email))));
//        return allCliente;
//    }

}
