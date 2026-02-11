package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.VentadetalleDTO;
import com.kt.MascotasMaravilla.mapper.VentadetalleMapper;
import com.kt.MascotasMaravilla.model.Ventadetalle;
import com.kt.MascotasMaravilla.repository.VentadetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentadetalleService {
    @Autowired
    private VentadetalleRepository ventadetalleRepository;
    @Autowired
    private VentadetalleMapper ventadetalleMapper;

    public void crear(VentadetalleDTO dto) {
        Ventadetalle ventadetalle = ventadetalleMapper.toEntity(dto);
        ventadetalleRepository.save(ventadetalle);
    }
    public List<VentadetalleDTO> lista() {
        List<Ventadetalle> ventadetalleList = ventadetalleRepository.findAll();
        return ventadetalleMapper.ventadetalleList(ventadetalleList);
    }
    public VentadetalleDTO listaId(int id) {
        Ventadetalle vd = ventadetalleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta Detalle no encontrada"));
        return ventadetalleMapper.toDto(vd);
    }
    public VentadetalleDTO editar(int id, VentadetalleDTO dto) {
        Ventadetalle vd = ventadetalleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta Detalle no encontrada"));
        ventadetalleMapper.updateVentaDetalle(dto, vd);
        Ventadetalle actualizado = ventadetalleRepository.save(vd);
        return ventadetalleMapper.toDto(actualizado);
    }
    public void borrar(int id) {
        if(!ventadetalleRepository.existsById(id)){
            throw new RuntimeException("Venta Detalle inexistente");
        }
        ventadetalleRepository.deleteById(id);
    }
}
