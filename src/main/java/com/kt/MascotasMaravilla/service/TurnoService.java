package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.TurnoDTO;
import com.kt.MascotasMaravilla.mapper.TurnoMapper;
import com.kt.MascotasMaravilla.model.Turno;
import com.kt.MascotasMaravilla.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private TurnoMapper turnoMapper;

    public void crear(TurnoDTO turnoDTO) {
        Turno turno = turnoMapper.toEntity(turnoDTO);
        turnoRepository.save(turno);
    }
    public List<TurnoDTO> lista() {
        List<Turno> turnoList = turnoRepository.findAll();
        return turnoMapper.turnoList(turnoList);
    }
    public TurnoDTO listaId(int id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        return turnoMapper.toDto(turno);
    }
    public TurnoDTO editar(int id, TurnoDTO turnoDTO) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        turnoMapper.updateTurno(turnoDTO, turno);
        Turno actualizado = turnoRepository.save(turno);
        return turnoMapper.toDto(actualizado);
    }
    public void borrar(int id) {
        if(!turnoRepository.existsById(id)){
            throw new RuntimeException("Turno inexistente");
        }
        turnoRepository.deleteById(id);
    }
}
