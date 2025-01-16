package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoResponseDTO;
import com.zup.pizzaria.dtos.PedidoRequestDTO;

public interface PedidoService {
    PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO);
}
