package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.dtos.PedidoRequestDTO;
import com.zup.pizzaria.dtos.PedidoResponseDTO;
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
        ClienteDTO clienteDTO = clienteRepository
                .findById(pedidoRequestDTO.getClienteId());
        PedidoDTO pedidoDTO = new PedidoDTO(pedidoRequestDTO.getDescricao(), pedidoRequestDTO.getValorTotal(), pedidoRequestDTO.getStatus(), clienteDTO.getId());
        pedidoRepository.save(pedidoDTO);

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
                    // Buscar cliente para cada pedido
                    ClienteDTO clienteDTO = clienteRepository.findById(pedido.getClienteId());
                    return new PedidoResponseDTO(clienteDTO.getNome(), clienteDTO.getEmail(), pedido.getDescricao());
                })
                .collect(Collectors.toList());
    }


}
