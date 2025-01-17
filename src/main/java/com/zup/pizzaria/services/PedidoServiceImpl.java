package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.dtos.PedidoRequestDTO;
import com.zup.pizzaria.dtos.PedidoResponseDTO;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PedidoDTO pedidoDTO = new PedidoDTO(clienteDTO.getId(), pedidoRequestDTO.getDescricao());
        pedidoRepository.save(pedidoDTO);

        return new PedidoResponseDTO(clienteDTO.getNome(), clienteDTO.getEmail(), pedidoRequestDTO.getDescricao());
    }

}
