package com.zup.pizzaria.repositories;

import com.zup.pizzaria.dtos.PedidoDTO;

import java.util.List;

public interface PedidoRepository {
    void save(PedidoDTO pedidoDTO);
    List<PedidoDTO> findAll();
    PedidoDTO findById(Long id);
}
