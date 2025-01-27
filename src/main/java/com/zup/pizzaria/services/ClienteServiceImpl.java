package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.dtos.ClienteResponseDTO;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteResponseDTO criarCliente(String nome, String email) {
        ClienteDTO clienteDTO = new ClienteDTO(nome, email);
        ClienteDTO clienteSalvo = clienteRepository.save(clienteDTO);

        return new ClienteResponseDTO(clienteSalvo.getId(), clienteSalvo.getNome(), clienteSalvo.getEmail());
    }

    @Override
    public List<ClienteResponseDTO> listarTodosClientes() {
        return clienteRepository.findAll().stream()
                .map(cliente -> new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }
}
