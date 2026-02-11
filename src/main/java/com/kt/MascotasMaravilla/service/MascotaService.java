package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.MascotaDTO;
import com.kt.MascotasMaravilla.mapper.MascotaMapper;
import com.kt.MascotasMaravilla.model.Mascota;
import com.kt.MascotasMaravilla.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private MascotaMapper mascotaMapper;

    public void crear(MascotaDTO mascotaDTO) {
        Mascota mascota = mascotaMapper.toEntity(mascotaDTO);
        mascotaRepository.save(mascota);
    }
    public List<MascotaDTO> lista() {
        List<Mascota> mascotaList = mascotaRepository.findAll();
        return mascotaMapper.mascotaList(mascotaList);
    }
    public MascotaDTO listaId(int id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        return mascotaMapper.toDto(mascota);
    }
    public MascotaDTO editar(int id, MascotaDTO mascotaDTO) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        mascotaMapper.updateMascota(mascotaDTO, mascota);
        Mascota actualizado = mascotaRepository.save(mascota);
        return mascotaMapper.toDto(actualizado);
    }
    public void borrar(int id) {
        if(!mascotaRepository.existsById(id)){
            throw new RuntimeException("Mascota inexistente");
        }
        mascotaRepository.deleteById(id);
    }
}
