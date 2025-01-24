package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO criarCliente(String nome, String email) {
        ClienteDTO clienteDTO = new ClienteDTO(nome, email);
        ClienteDTO clienteSalvo = clienteRepository.save(clienteDTO);

        return new ClienteDTO(clienteSalvo.getId(), clienteSalvo.getNome(), clienteSalvo.getEmail());
    }

    @Override
    public List<ClienteDTO> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteDTO buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }
}
