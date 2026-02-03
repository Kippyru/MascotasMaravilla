package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.UsuarioDTO;
import com.kt.MascotasMaravilla.model.Persona;
import com.kt.MascotasMaravilla.model.Usuario;
import com.kt.MascotasMaravilla.repository.PersonaRepository;
import com.kt.MascotasMaravilla.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaRepository personaRepository;

    public void create(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        Persona persona = personaRepository.findById(usuarioDTO.getIdPersona())
                        .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        usuario.setIdPersona(persona);
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setActivo(usuarioDTO.getActivo());

        usuarioRepository.save(usuario);
    }

    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    public Usuario listID(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void update(int id, UsuarioDTO usuarioDTO) {
        Usuario usuario = listID(id);

        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setActivo(usuarioDTO.getActivo());

        if (usuarioDTO.getIdPersona() != null) {
            Persona persona = personaRepository.findById(usuarioDTO.getIdPersona())
                    .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

            usuario.setIdPersona(persona);
            usuarioRepository.save(usuario);
        }
    }

    public void delete(int id) {
        usuarioRepository.deleteById(id);}
}
