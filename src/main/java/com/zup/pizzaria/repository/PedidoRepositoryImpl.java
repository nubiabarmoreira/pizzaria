package com.zup.pizzaria.repository;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {
    @Autowired
    private JpaPedidoRepository jpaPedidoRepository;

    @Override
    public void save(PedidoDTO pedidoDTO) {
        Pedido pedidoEntidade = new Pedido(pedidoDTO.getClienteId(), pedidoDTO.getDescricao());

        jpaPedidoRepository.save(pedidoEntidade);
    }

    @Override
    public List<PedidoDTO> findAll() {
        List<Pedido> pedidos = jpaPedidoRepository.findAll();
        return pedidos.stream()
                .map(pedido -> new PedidoDTO(pedido.getClienteId(), pedido.getDescricao()))
                .collect(Collectors.toList());
    }


}
