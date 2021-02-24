package com.ufla.zetta.jpa.demo.controller;

import com.ufla.zetta.jpa.demo.model.Categoria;
import com.ufla.zetta.jpa.demo.model.dto.CategoriaDTO;
import com.ufla.zetta.jpa.demo.service.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarCategoriaById(@PathVariable Integer id) {

        CategoriaDTO categoriaDTO = this.categoriaService
                .buscarCategoriaById(id).orElse(null);
        if (categoriaDTO != null) {
            return ResponseEntity.ok().body(categoriaDTO);
        } else {
            return ResponseEntity.badRequest().body("Categoria não encontrado com o ID: "+ id);
        }

    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {

        Categoria categoria = Categoria.builder()
                .id(1)
                .nome("Papelaria a")
                .build();

        Categoria categoria2 = Categoria.builder()
                .id(2)
                .nome("Informatic")
                .build();

        CategoriaDTO categoriaDTO = this.modelMapper.map(categoria, CategoriaDTO.class);

        CategoriaDTO categoriaDTO2 = this.modelMapper.map(categoria2, CategoriaDTO.class);

        List<CategoriaDTO> all = new ArrayList<>();
        all.addAll(Arrays.asList(categoriaDTO, categoriaDTO2));

        return ResponseEntity.ok(all);
    }

}
