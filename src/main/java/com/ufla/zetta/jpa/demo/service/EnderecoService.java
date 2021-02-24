package com.ufla.zetta.jpa.demo.service;

import com.ufla.zetta.jpa.demo.model.Endereco;
import com.ufla.zetta.jpa.demo.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Optional<Endereco> buscarEnderecoById(Integer id) {
        return this.enderecoRepository.findById(id);
    }


}
