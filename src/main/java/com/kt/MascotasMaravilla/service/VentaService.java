package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.VentaDTO;
import com.kt.MascotasMaravilla.mapper.VentaMapper;
import com.kt.MascotasMaravilla.model.Venta;
import com.kt.MascotasMaravilla.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private VentaMapper ventaMapper;

    public void crear(VentaDTO ventaDTO) {
        Venta venta = ventaMapper.toEntity(ventaDTO);
        ventaRepository.save(venta);
    }
    public List<VentaDTO> lista() {
        List<Venta> ventaList = ventaRepository.findAll();
        return ventaMapper.ventaList(ventaList);
    }
    public VentaDTO listaId(int id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        return ventaMapper.toDto(venta);
    }
    public VentaDTO editar(int id, VentaDTO categoriaDTO) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        ventaMapper.updateVenta(categoriaDTO, venta);
        Venta actualizado = ventaRepository.save(venta);
        return ventaMapper.toDto(actualizado);
    }
    public void borrar(int id) {
        if(!ventaRepository.existsById(id)){
            throw new RuntimeException("Venta inexistente");
        }
        ventaRepository.deleteById(id);
    }
}
