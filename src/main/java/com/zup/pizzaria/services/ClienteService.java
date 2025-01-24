package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO criarCliente (String nome, String email);
    List<ClienteDTO> listarTodosClientes ();

}
