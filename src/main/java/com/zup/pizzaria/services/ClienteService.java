package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.dtos.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO criarCliente (String nome, String email);
    List<ClienteResponseDTO> listarTodosClientes ();
    ClienteDTO buscarClientePorId(Long id);
}
