package com.zup.pizzaria.repository;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {
    @Autowired
    private JpaPedidoRepository jpaPedidoRepository;

    @Override
    public void save(PedidoDTO pedidoDTO) {
        Pedido pedidoEntidade = new Pedido(pedidoDTO.getClienteId(), pedidoDTO.getDescricao());

        jpaPedidoRepository.save(pedidoEntidade);
    }

}
