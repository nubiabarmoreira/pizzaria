package com.zup.pizzaria.repositories;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
