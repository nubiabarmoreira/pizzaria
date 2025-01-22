package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoResponseDTO;
import com.zup.pizzaria.dtos.PedidoRequestDTO;

import java.util.List;

public interface PedidoService {
    PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO);

    PedidoResponseDTO buscarPedidoPorId(Long id);

    List<PedidoResponseDTO> listarTodosPedidos();
}
