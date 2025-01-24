package com.zup.pizzaria.repository;

import com.zup.pizzaria.dtos.ClienteDTO;

import java.util.List;

public interface ClienteRepository {
    ClienteDTO findById(Long id);
    ClienteDTO save(ClienteDTO clienteDTO);
    List<ClienteDTO> findAll();
}
