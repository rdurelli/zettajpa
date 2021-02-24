package com.ufla.zetta.jpa.demo.service;

import com.ufla.zetta.jpa.demo.exception.ObjectNotFoundException;
import com.ufla.zetta.jpa.demo.model.Categoria;
import com.ufla.zetta.jpa.demo.model.dto.CategoriaDTO;
import com.ufla.zetta.jpa.demo.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public Optional<CategoriaDTO> buscarCategoriaById(Integer id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        Categoria categoria1 = categoria.
                orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado com o id :" + id));
        return Optional.of(this.mapEntityToDTO(categoria1));
    }

    private CategoriaDTO mapEntityToDTO(Categoria categoria) {
        return this.modelMapper.map(categoria, CategoriaDTO.class);
    }

}
