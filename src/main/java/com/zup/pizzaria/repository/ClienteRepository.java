package com.zup.pizzaria.repository;

import com.zup.pizzaria.dtos.ClienteDTO;

public interface ClienteRepository {
    ClienteDTO findById(Long id);
    ClienteDTO save(ClienteDTO clienteDTO);
}
