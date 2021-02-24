package com.ufla.zetta.jpa.demo.service;

import com.ufla.zetta.jpa.demo.model.Produto;
import com.ufla.zetta.jpa.demo.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }

    public void deleteProduto(Integer id) {
        this.produtoRepository.deleteById(id);
    }


}
