package com.zup.pizzaria.repository;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.exptions.ClienteNaoEncontradoException;
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
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));

        return new ClienteDTO(clienteEntidade.getId(), clienteEntidade.getNome(), clienteEntidade.getEmail());
    }

    @Override
    public void save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getEmail());
        jpaClienteRepository.save(cliente);
    }
}
