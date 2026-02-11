package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.CategoriaDTO;
import com.kt.MascotasMaravilla.mapper.CategoriaMapper;
import com.kt.MascotasMaravilla.model.Categoria;
import com.kt.MascotasMaravilla.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaMapper categoriaMapper;

    public void crear(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        categoriaRepository.save(categoria);
    }
    public List<CategoriaDTO> lista() {
        List<Categoria> categoriaList = categoriaRepository.findAll();
        return categoriaMapper.toList(categoriaList);
    }
    public CategoriaDTO listaId(int id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        return categoriaMapper.toDto(categoria);
    }
    public CategoriaDTO editar(int id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoriaMapper.updateCategoria(categoriaDTO, categoria);
        Categoria actualizado = categoriaRepository.save(categoria);
        return categoriaMapper.toDto(actualizado);
    }
    public void borrar(int id) {
        if(!categoriaRepository.existsById(id)){
            throw new RuntimeException("categoria inexistente");
        }
        categoriaRepository.deleteById(id);
    }
}
