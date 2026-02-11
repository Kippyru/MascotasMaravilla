package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.StaffDTO;
import com.kt.MascotasMaravilla.mapper.StaffMapper;
import com.kt.MascotasMaravilla.model.Staff;
import com.kt.MascotasMaravilla.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private StaffMapper staffMapper;

    public void crear(StaffDTO staffDTO) {
        Staff staff = staffMapper.toEntity(staffDTO);
        staffRepository.save(staff);
    }
    public List<StaffDTO> lista() {
        List<Staff> staffList = staffRepository.findAll();
        return staffMapper.staffList(staffList);
    }
    public StaffDTO listaId(int id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff no encontrado"));
        return staffMapper.toDto(staff);
    }
    public StaffDTO editar(int id, StaffDTO staffDTO) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff no encontrado"));
        staffMapper.updateStaff(staffDTO, staff);
        Staff actualizado = staffRepository.save(staff);
        return staffMapper.toDto(actualizado);
    }
    public void borrar(int id) {
        if(!staffRepository.existsById(id)){
            throw new RuntimeException("Staff inexistente");
        }
        staffRepository.deleteById(id);
    }
}
