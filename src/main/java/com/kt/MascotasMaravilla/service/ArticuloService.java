package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.ArticuloDTO;
import com.kt.MascotasMaravilla.mapper.ArticuloMapper;
import com.kt.MascotasMaravilla.model.Articulo;
import com.kt.MascotasMaravilla.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;
    @Autowired
    private ArticuloMapper articuloMapper;

    public void crear(ArticuloDTO articuloDTO) {
        Articulo articulo = articuloMapper.toEntity(articuloDTO);
        articuloRepository.save(articulo);
    }

    public List<ArticuloDTO> lista(){
        List<Articulo> articuloList = articuloRepository.findAll();
        return articuloMapper.articuloList(articuloList);
    }

    public ArticuloDTO listaId(int id) {
        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Articulo no encontrado"));
        return articuloMapper.toDto(articulo);
    }

    public ArticuloDTO editar(int id, ArticuloDTO articuloDTO) {
        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Articulo no encontrado"));
        articuloMapper.updateArticulo(articuloDTO, articulo);
        Articulo actualizado = articuloRepository.save(articulo);
        return articuloMapper.toDto(actualizado);
    }

    public void borrar(int id) {
        if(!articuloRepository.existsById(id)){
            throw new RuntimeException("Articulo inexistente");
        }
        articuloRepository.deleteById(id);
    }
}
