package com.ufla.zetta.jpa.demo.controller;

import com.ufla.zetta.jpa.demo.model.Produto;
import com.ufla.zetta.jpa.demo.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAllProdutos() {
        List<Produto> allProdutos = this.produtoService.findAll();
        if (allProdutos != null) {
            return allProdutos;
        } else {
            return null;
        }
    }

}
