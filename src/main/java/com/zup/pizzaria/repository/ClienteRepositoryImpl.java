package com.zup.pizzaria.repository;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    @Autowired
    private JpaClienteRepository jpaClienteRepository;

    @Override
    public ClienteDTO findById(Long id) {
        Cliente clienteEntidade = jpaClienteRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return new ClienteDTO(clienteEntidade.getId(), clienteEntidade.getNome(), clienteEntidade.getEmail());
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getEmail());
        Cliente clienteSalvo = jpaClienteRepository.save(cliente);

        return new ClienteDTO(clienteSalvo.getId(), clienteSalvo.getNome(), clienteSalvo.getEmail());
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = jpaClienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail()))
                .collect(Collectors.toList());
    }
}
