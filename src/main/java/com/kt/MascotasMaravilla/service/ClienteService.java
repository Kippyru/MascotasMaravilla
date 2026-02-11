package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.ClienteDTO;
import com.kt.MascotasMaravilla.mapper.ClienteMapper;
import com.kt.MascotasMaravilla.model.Cliente;
import com.kt.MascotasMaravilla.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    public void crear(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        clienteRepository.save(cliente);
    }

    public List<ClienteDTO> lista(){
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteMapper.clienteList(clienteList);
    }

    public ClienteDTO listaId(int id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return clienteMapper.toDto(cliente);
    }

    public ClienteDTO editar(int id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clienteMapper.updateCliente(clienteDTO, cliente);
        Cliente actualizado = clienteRepository.save(cliente);
        return clienteMapper.toDto(actualizado);
    }

    public void borrar(int id) {
        if(!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente inexistente");
        }
        clienteRepository.deleteById(id);
    }
}
