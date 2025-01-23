package com.zup.pizzaria.repository;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.exceptions.PedidoNaoEncontradoException;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {
    @Autowired
    private JpaPedidoRepository jpaPedidoRepository;

    @Autowired
    private JpaClienteRepository jpaClienteRepository;

    @Override
    public void save(PedidoDTO pedidoDTO) {
        Cliente cliente = jpaClienteRepository.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Pedido pedidoEntidade = new Pedido(pedidoDTO.getDescricao(), pedidoDTO.getValorTotal(), pedidoDTO.getStatus(), cliente);

        jpaPedidoRepository.save(pedidoEntidade);
    }

    @Override
    public PedidoDTO findById(Long id) {
        Pedido pedido = jpaPedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido com ID " + id + " não foi encontrado."));
        PedidoDTO pedidoDTO = new PedidoDTO(pedido.getDescricao(), pedido.getValorTotal(), pedido.getStatus(), pedido.getId());
        return pedidoDTO;
    }

    @Override
    public List<PedidoDTO> findAll() {
        List<Pedido> pedidos = jpaPedidoRepository.findAll();
        return pedidos.stream()
                .map(pedido -> new PedidoDTO(pedido.getDescricao(), pedido.getValorTotal(), pedido.getStatus(), pedido.getCliente().getId()))
                .collect(Collectors.toList());
    }


}
