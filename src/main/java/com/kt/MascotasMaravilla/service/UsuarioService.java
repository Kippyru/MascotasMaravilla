package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.UsuarioDTO;
import com.kt.MascotasMaravilla.mapper.UsuarioMapper;
import com.kt.MascotasMaravilla.model.Usuario;
import com.kt.MascotasMaravilla.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public void crear(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuarioRepository.save(usuario);
    }
    public List<UsuarioDTO> lista() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return usuarioMapper.toDtoList(usuarioList);
    }
    public UsuarioDTO listaId(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toDto(usuario);
    }
    public UsuarioDTO editar(int id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioMapper.updateEntity(usuarioDTO, usuario);
        Usuario actualizado = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(actualizado);
    }
    public void borrar(int id) {
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario inexistente");
        }
        usuarioRepository.deleteById(id);
    }

}
