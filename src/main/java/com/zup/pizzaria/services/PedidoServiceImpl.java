package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.dtos.PedidoRequestDTO;
import com.zup.pizzaria.dtos.PedidoResponseDTO;
import com.zup.pizzaria.exceptions.PedidoInvalidoException;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {
        PedidoDTO pedidoDTO = new PedidoDTO(pedidoRequestDTO.getDescricao(), pedidoRequestDTO.getValorTotal(), pedidoRequestDTO.getStatus(), pedidoRequestDTO.getClienteId());
        pedidoRepository.save(pedidoDTO);

        ClienteDTO clienteDTO = clienteRepository.findById(pedidoRequestDTO.getClienteId());

        return new PedidoResponseDTO(clienteDTO.getNome(), clienteDTO.getEmail(), pedidoRequestDTO.getDescricao());
    }

    @Override
    public PedidoResponseDTO buscarPedidoPorId(Long id) {
        PedidoDTO pedidoDTO = pedidoRepository.findById(id);
        ClienteDTO clienteDTO = clienteRepository.findById(pedidoDTO.getClienteId());
        return new PedidoResponseDTO(clienteDTO.getNome(), clienteDTO.getEmail(), pedidoDTO.getDescricao());
    }

    @Override
    public List<PedidoResponseDTO> listarTodosPedidos() {
        List<PedidoDTO> pedidoDTO = pedidoRepository.findAll();

        return pedidoDTO.stream()
                .map(pedido -> {
                    ClienteDTO clienteDTO = clienteRepository.findById(pedido.getClienteId());
                    return new PedidoResponseDTO(clienteDTO.getNome(), clienteDTO.getEmail(), pedido.getDescricao());
                })
                .collect(Collectors.toList());
    }

    @Override
    public PedidoResponseDTO atualizarDadosDoPedido(Long id, PedidoRequestDTO pedidoRequestDTO) {
        PedidoDTO pedidoDTO = pedidoRepository.findById(id);

        if (pedidoRequestDTO.getDescricao() != null) {
            if (pedidoRequestDTO.getDescricao().isEmpty()) {
                throw new PedidoInvalidoException("Descrição do pedido não pode ser vazia.");
            }
            pedidoDTO.setDescricao(pedidoRequestDTO.getDescricao());
        }

        if (pedidoRequestDTO.getValorTotal() != null) {
            if (pedidoRequestDTO.getValorTotal() <= 0) {
                throw new PedidoInvalidoException("O valor total do pedido deve ser maior que zero.");
            }
            pedidoDTO.setValorTotal(pedidoRequestDTO.getValorTotal());
        }

        if (pedidoRequestDTO.getStatus() != null) {
            pedidoDTO.setStatus(pedidoRequestDTO.getStatus());
        }

        if (pedidoRequestDTO.getClienteId() != null) {
            if (pedidoRequestDTO.getClienteId() <= 0) {
                throw new PedidoInvalidoException("Cliente ID deve ser válido.");
            }
            pedidoDTO.setClienteId(pedidoRequestDTO.getClienteId());
        }

        pedidoRepository.update(id, pedidoDTO);

        ClienteDTO clienteDTO = clienteRepository.findById(pedidoDTO.getClienteId());

        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO(
                clienteDTO.getNome(),
                clienteDTO.getEmail(),
                pedidoDTO.getDescricao()
        );

        return pedidoResponseDTO;
    }

}
