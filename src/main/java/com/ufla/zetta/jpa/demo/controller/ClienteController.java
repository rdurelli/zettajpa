package com.ufla.zetta.jpa.demo.controller;

import com.ufla.zetta.jpa.demo.model.Cliente;
import com.ufla.zetta.jpa.demo.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public Cliente findById(@PathVariable Integer id) {
        return this.clienteService.findClienteById(id);
    }

//    @GetMapping(value = "consultar-nome/{nome}")
//    public List<Cliente> consultarPorNome(@PathVariable String nome) {
//        return this.clienteService.consultarClientePorNome(nome);
//    }
//
    @GetMapping(value = "consultar-nome-email/{nome}/{email}")
    public List<Cliente> consultarPorNomeEmail(@PathVariable String nome, @PathVariable String email) {
        return this.clienteService.consultarOnLine(nome,email);
    }


}
