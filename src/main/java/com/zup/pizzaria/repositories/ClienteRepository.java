package com.zup.pizzaria.repositories;

import com.zup.pizzaria.dtos.ClienteDTO;

public interface ClienteRepository {
    ClienteDTO findById(Long id);
    ClienteDTO save(ClienteDTO clienteDTO);
}
