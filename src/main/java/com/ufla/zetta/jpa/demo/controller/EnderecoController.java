package com.ufla.zetta.jpa.demo.controller;

import com.ufla.zetta.jpa.demo.exception.ObjectNotFoundException;
import com.ufla.zetta.jpa.demo.model.Endereco;
import com.ufla.zetta.jpa.demo.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;


    @GetMapping(value = "/{id}")
    public Endereco buscarEnderecoById(@PathVariable Integer id) {
        return this.enderecoService.buscarEnderecoById(id).orElseThrow(() -> new ObjectNotFoundException("Endereco não encontrado com o id: "+ id));
    }


}
