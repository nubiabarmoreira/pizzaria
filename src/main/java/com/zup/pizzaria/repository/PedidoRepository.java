package com.zup.pizzaria.repository;

import com.zup.pizzaria.dtos.PedidoDTO;

public interface PedidoRepository {
    void save(PedidoDTO pedidoDTO);
}
