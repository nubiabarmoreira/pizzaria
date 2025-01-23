package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;

public interface ClienteService {
    ClienteDTO criarCliente (String nome, String email);

}
